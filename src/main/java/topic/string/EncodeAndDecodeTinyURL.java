package topic.string;

import java.util.HashMap;

// https://leetcode.com/problems/encode-and-decode-tinyurl/
public class EncodeAndDecodeTinyURL {
    private HashMap<String, String> shortToLongUrl = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hash = getShortURL(longUrl);

        if (!shortToLongUrl.containsKey(hash)) {
            shortToLongUrl.put(hash, longUrl);
        }

        return hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongUrl.getOrDefault(shortUrl, "");
    }

    public String getShortURL(String url) {
        return "http://tiny.url/" + Integer.toString(url.hashCode(), 16);
    }
}
