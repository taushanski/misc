package first_iteration.arrays_and_strings_1;

import java.util.Arrays;

public class PermuntationCheck {

    public static void main(String... args) {
        String st1 =
                "abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;";
        String st2 =
                "cbadasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;abcdasdfkajsdfa;lksdjf;alksjfl;askdjfl;askdjf;lajsdfl;aksjdfl;aksjdf;laskjfl;askdjf;lasdjkf;aksdjf;";
        System.out.printf("WithSortingApproach:Is the following string:%s a permuntation of %s :%b%n", st1, st2,
                isPermuntation_WithStoring(st1, st2));
        System.out.printf("CountCharactersApproach:Is the following string:%s a permuntation of %s :%b%n", st1, st2,
                isPermuntation_CountCharacters(st1, st2, 256));
    }

    private static boolean isPermuntation_WithStoring(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        long startTime = System.currentTimeMillis();
        boolean result = sort(s1).equals(sort(s2));
        System.out.printf("isPermuntation_WithStoring took: %d ms%n", System.currentTimeMillis() - startTime);
        return result;
    }

    private static String sort(String content) {
        char[] chars = content.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static Object isPermuntation_CountCharacters(String s1, String s2, int charsetSize) {
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean result = true;
        long startTime = System.currentTimeMillis();

        int[] charsCount = new int[charsetSize];

        for (char nextChar : s1.toCharArray()) {
            charsCount[nextChar]++;
        }

        for (char nextChar : s2.toCharArray()) {
            charsCount[nextChar]--;
            if (charsCount[nextChar] < 0) {
                result = false;
                break;
            }
        }
        System.out.printf("isPermuntation_CountCharacters took: %d ms%n", System.currentTimeMillis() - startTime);
        return result;
    }


}