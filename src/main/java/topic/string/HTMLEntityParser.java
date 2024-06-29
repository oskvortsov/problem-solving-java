package topic.string;

import java.util.Map;

public class HTMLEntityParser {
    Map<String, String> codeMap = Map.of(
            "&quot;", "\"",
            "&apos;","'",
            "&amp;","&",
            "&gt;",">",
            "&lt;","<",
            "&frasl;","/"
    );

    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            sb.append(symbol);

            if (symbol == '&') startIndex = i;
            if (symbol == ';') {

                String code = text.substring(startIndex, i + 1);

                if (codeMap.containsKey(code)) {
                    sb.replace(sb.length() - code.length(), sb.length(), codeMap.get(code));
                }
                startIndex = i;
            }
        }

        return sb.toString();
    }
}
