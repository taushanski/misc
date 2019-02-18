package base64;

import java.util.Base64;
import java.util.UUID;

public class Base64Play {

    public static void main(String[] args) {
        {
            String originalInput = "test input кирил ääö";
            String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
            System.out.printf("The source string to encode is:%s %n", originalInput);
            System.out.printf("The encoded string is:%s %n", encodedString);
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            String decodedString = new String(decodedBytes);
            System.out.printf("The decoded string is:%s %n", decodedString);
        }

        System.out.println("================Demo with the mime encoder================");

        {
            String originalInput = getMimeBuffer().toString();
            String encodedString = Base64.getMimeEncoder().encodeToString(originalInput.getBytes());
            System.out.printf("The source string to encode is:%s %n", originalInput);
            System.out.printf("The encoded string is:%s %n", encodedString);
            byte[] decodedBytes = Base64.getMimeDecoder().decode(encodedString);
            String decodedString = new String(decodedBytes);
            System.out.printf("The decoded string is:%s %n", decodedString);
        }

        System.out.println("================================");

        {
            String originalInput =
                    "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPFBhY2thZ2luZ0RvY3VtZW50PgogICAgPFBhY2\n" +
                    "        thZ2luZ0RvY3VtZW50TWV0YURhdGE+CiAgICAgICAgPERvY3VtZW50U3RhdHVzPm5ldzwvRG9jdW1lbnRTdGF0dXM+\n" +
                    "        CiAgICAgICAgPE1hdGVyaWFsR3JvdXA+CiAgICAgICAgICAgIDxNYXRlcmlhbEdyb3VwTnVtYmVyPkMwMDM0PC9NYX\n" +
                    "        RlcmlhbEdyb3VwTnVtYmVyPgogICAgICAgICAgICA8TWF0ZXJpYWxHcm91cE5hbWU+QXV4QWRkaXRpdmVzPC9NYXRl\n" +
                    "        cmlhbEdyb3VwTmFtZT4KICAgICAgICA8L01hdGVyaWFsR3JvdXA+Cgk8TWF0ZXJpYWw+CgkgICAgPE1hdGVyaWFsTn\n" +
                    "        VtYmVyPktMNzYzNDI8L01hdGVyaWFsTnVtYmVyPgoJICAgIDxNYXRlcmlhbERlc2NyaXB0aW9uLz4KICAgICAgICA8\n" +
                    "        L01hdGVyaWFsPgogICAgPC9QYWNrYWdpbmdEb2N1bWVudE1ldGFEYXRhPgogICAgPFBERiBmaWxlbmFtZT0iUENLUk\n" +
                    "        xFLUMwMDAwLlBERiIgbGFuZ3VhZ2U9IkVOIiBmaWxldmVyc2lvbj0iMS4yIiByZWxlYXNlZGF0ZT0iMjAxOC0wMy0x\n" +
                    "        NyI+CiAgICA8L1BERj4KPC9QYWNrYWdpbmdEb2N1bWVudD4=";
            System.out.printf("The encoded string is:%s %n", originalInput);
            byte[] decodedBytes = Base64.getMimeDecoder().decode(originalInput);
            String decodedString = new String(decodedBytes);
            System.out.printf("The decoded string is:%s %n", decodedString);
        }
    }


    private static StringBuilder getMimeBuffer() {
        StringBuilder buffer = new StringBuilder();
        for (int count = 0; count < 10; ++count) {
            buffer.append(UUID.randomUUID().toString());
        }
        return buffer;
    }
}
