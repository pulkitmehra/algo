package org.comp.design.tinyurl;

public interface TinyUrlDesignInterface {

    static long DEFAULT_TTL_IN_HOURS = 24L;

    /*
     * Given a URL, our service should generate a shorter and unique alias of it. This is called a short link.
     */
    public String createTinyUrl(String authtoken, String origUrl);

    /*
     * Users should optionally be able to pick a custom short link for their URL. Links will expire after a standard
     * default timespan. Users should also be able to specify the expiration time.
     */
    public void createTinyUrl(String authtoken, String origUrl, String customName, long ttl) throws NameInUseException;

    /*
     * When users access a short link, our service should redirect them to the original link.
     */
    public String expand(String authtoken, String tinyUrl) throws URLNotFound;

    public void delete(String tinyUrl) throws URLNotFound;


    public static class NameInUseException extends Exception {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

    }

    public static class URLNotFound extends Exception {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

    }
}


