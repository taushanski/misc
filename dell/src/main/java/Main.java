import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Permission p1 = IdentityManagement.createPermission("View Invoices");
        Permission p2 = IdentityManagement.createPermission("View Subscriptions");
        Permission p3 = IdentityManagement.createPermission("Manage Subscriptions");
        Permission p4 = IdentityManagement.createPermission("Create Users");

        Role administrator = IdentityManagement.createRole("Administrator", Arrays.asList(p1, p2, p3, p4));
        Role financeUser = IdentityManagement.createRole("Finance User", Arrays.asList(p1, p2));
        Role powerUser = IdentityManagement.createRole("Power User", Arrays.asList(p1, p2, p3));
        Role organizationManager = IdentityManagement.createRole("Organization Manager", Arrays.asList(p4));
        // user1 permissions: {View Invoices, View Subscriptions, View Invoices, View Subscriptions, Manage Subscriptions}
        // user1 permissions: {p1,p2,   p1,p2,p3}
        // user2 permissions: {p1, p2, p3,   p4}
        User user1 = IdentityManagement.createUser("User 1", Arrays.asList(financeUser, powerUser));
        User user2 = IdentityManagement.createUser("User 2", Arrays.asList(powerUser, organizationManager));
        User user3 = IdentityManagement.createUser("User 3", Arrays.asList(financeUser, organizationManager));

        IdentityManagement.updateRole("Power User", Arrays.asList(p1, p3, p4));

        IdentityManagement.updateUser("User 3", Arrays.asList(financeUser, administrator));

    }
}

class Permission {

    private String name;

    public Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}

class Role {

    private String name;

    private List<Permission> permissions;

    public Role(String name, List<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return getName() != null ? getName().equals(role.getName()) : role.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}

class User {

    private String name;

    private List<Role> roles;

    public User(String name, List<Role> roles) {
        this.name = name;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        roles = roles;
    }
}

class IdentityManagement {

    private static Map<String, Permission> permissions = new HashMap<>();

    private static Map<String, Role> roles = new HashMap<>();

    private static Map<String, User> users = new HashMap<>();

    public static Role getRole(String name) {
        return roles.get(name);
    }

    private static User getUser(String name) {
        return users.get(name);
    }

    public static Permission createPermission(String name) {
        Permission permission = new Permission(name);
        permissions.put(name, permission);
        return permission;
    }

    public static Role createRole(String name, List<Permission> permissions) {
        Role role = new Role(name, permissions);
        roles.put(name, role);
        return role;
    }

    public static User createUser(String name, List<Role> roles) {
        User user = new User(name, roles);
        users.put(name, user);
        return user;
    }

    public static void updateRole(String name, List<Permission> newPermissions) {
        Role role = getRole(name);
        notifyInterestedServices(role, newPermissions);
        role.setPermissions(newPermissions);
    }

    private static void notifyInterestedServices(Role oldRoleState, List<Permission> newRolePermissions) {
        users.values().stream().filter(user -> user.getRoles().contains(oldRoleState)).forEach(user -> {
            // calculate the delta for the current user
            List<Permission> currentUserPermissionsExcludingGivenRole =
                    user.getRoles().stream()
                            .filter(role1 -> !role1.getName().equals(oldRoleState.getName()))
                            .flatMap(
                                    nextRole -> nextRole.getPermissions().stream()).collect(
                            Collectors.toList());


            List<Permission> permissionsToAdd = new ArrayList<>(newRolePermissions);
            permissionsToAdd.removeAll(oldRoleState.getPermissions());
            permissionsToAdd.removeAll(currentUserPermissionsExcludingGivenRole);

            List<Permission> permissionsToRemove = new ArrayList<>(oldRoleState.getPermissions());
            permissionsToRemove.removeAll(newRolePermissions);
            permissionsToRemove.removeAll(currentUserPermissionsExcludingGivenRole);

            if (!permissionsToAdd.isEmpty() || !permissionsToRemove.isEmpty()) {
                NotificationSettingsManagement.updatePermissionsMapping(user.getName(), permissionsToAdd,
                                                                        permissionsToRemove);
            }

        });
    }

    public static void updateUser(String name, List<Role> roles) {
        User user = getUser(name);
        if (user == null) {
            throw new IllegalArgumentException("Cannot update non existing user");
        }

        List<Permission> userCurrentPermissions = user.getRoles().stream().flatMap(
                nextRole -> nextRole.getPermissions().stream()).collect(Collectors.toList());


        List<Permission> userNewPermissions = roles.stream().flatMap(
                nextRole -> nextRole.getPermissions().stream()).collect(Collectors.toList());

        List<Permission> permissionsToRemove = userCurrentPermissions.stream().filter(
                permission -> !userNewPermissions.contains(permission)).collect(
                Collectors.toList());

        List<Permission> permissionsToAdd = userNewPermissions.stream().filter(
                permission -> !userCurrentPermissions.contains(permission)).collect(
                Collectors.toList());

        NotificationSettingsManagement.updatePermissionsMapping(name, permissionsToAdd, permissionsToRemove);

        user.setRoles(roles);
    }

}
/*
 * This class stores permissions for each users.
 * The permissions mapping needs to be updated each time a user or role is changed.
 */

class NotificationSettingsManagement {

    public static void updatePermissionsMapping(String userName, List<Permission> permissionsToAdd,
                                                List<Permission> permissionsToRemove) {
        System.out.printf("Updating permissions for user: %s%n", userName);
        permissionsToAdd.stream()
                .forEach(permission -> System.out.printf("Added permission: %s%n", permission.getName()));
        permissionsToRemove.stream()
                .forEach(permission -> System.out.printf("Removed permission: %s%n", permission.getName()));
    }

}
