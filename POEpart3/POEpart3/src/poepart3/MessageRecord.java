/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart3;

/**
 *
 * @author Student
 */
class MessageRecord {

    private static final Random RANDOM = new Random();

    private final String id;
    private final int number;
    private final String recipient;
    private final String text;
    private final String flag;
    private final String hash;

    /** Creates a new message with a generated 10 digit ID and hash. */
    public MessageRecord(int number, String recipient, String text, String flag) {
        this(generateId(), number, recipient, text, flag);
    }

    /** Creates a message with a known ID (used when reading from JSON). */
    public MessageRecord(String id, int number, String recipient, String text, String flag) {
        this.id = id;
        this.number = number;
        this.recipient = recipient;
        this.text = text;
        this.flag = flag;
        this.hash = createHash(id, number, text);
    }

    private static String generateId() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }

    /** Hash: first two digits of ID : message number : FIRSTWORDLASTWORD (upper case). */
    public static String createHash(String id, int number, String text) {
        String[] words = text.trim().split("\\s+");
        String first = words[0].replaceAll("[^A-Za-z0-9]", "");
        String last = words[words.length - 1].replaceAll("[^A-Za-z0-9]", "");
        return (id.substring(0, 2) + ":" + number + ":" + first + last).toUpperCase();
    }

    public int getNumber() { return number; }
    public String getRecipient() { return recipient; }
    public String getText() { return text; }
    public String getFlag() { return flag; }
    public String getHash() { return hash; }

    String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class Random {

        public Random() {
        }
    }
    
}
