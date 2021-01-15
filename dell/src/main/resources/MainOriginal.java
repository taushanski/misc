import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Permission {

    private String name;

    public Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public static void updateRole(String name, List<Permission> permissions) {
        Role role = getRole(name);
        role.setPermissions(permissions);
    }

    public static void updateUser(String name, List<Role> roles) {
        User user = getUser(name);
        users.put(name, user);
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

        User user1 = IdentityManagement.createUser("User 1", Arrays.asList(financeUser, powerUser));
        User user2 = IdentityManagement.createUser("User 2", Arrays.asList(powerUser, organizationManager));

        IdentityManagement.updateRole("Power User", Arrays.asList(p1, p3, p4));
    }
}
