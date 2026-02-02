import java.util.*;

public class Chatbot {

    // Rule-based knowledge base
    private static final Map<String, String> RULES = new HashMap<>();

    public static void main(String[] args) {
        trainRules();
        Scanner sc = new Scanner(System.in);

        System.out.println("🤖 AI Chatbot: Hi! Ask me anything (type 'exit' to quit)");

        while (true) {
            System.out.print("You: ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("🤖 AI Chatbot: Goodbye! 👋");
                break;
            }

            // NLP preprocessing
            String processed = preprocess(input);

            // Quick rule-based response
            String response = getRuleBasedResponse(processed);
            System.out.println("🤖 AI Chatbot: " + response);
        }

        sc.close();
    }

    // Train bot with FAQs (Rule-Based)
    private static void trainRules() {
        RULES.put("hi", "Hello! How can I help you?");
        RULES.put("hello", "Hi there! 😊");
        RULES.put("how are you", "I'm doing great! Thanks for asking.");
        RULES.put("your name", "I am an AI Chatbot built using Java.");
        RULES.put("what is java", "Java is an object-oriented programming language used for building applications.");
        RULES.put("what is ai", "AI stands for Artificial Intelligence, which enables machines to think and learn.");
        RULES.put("bye", "Goodbye! Have a nice day 😊");
        RULES.put("thank you", "You're welcome! Happy to help.");
    }

    // Basic NLP: preprocessing
    private static String preprocess(String text) {
        // Convert to lowercase
        text = text.toLowerCase();

        // Remove punctuation
        text = text.replaceAll("[^a-z0-9\\s]", "");

        // Normalize extra spaces
        text = text.replaceAll("\\s+", " ").trim();

        return text;
    }

    // Rule-based matching for quick response
    private static String getRuleBasedResponse(String input) {
        for (Map.Entry<String, String> rule : RULES.entrySet()) {
            if (input.contains(rule.getKey())) {
                return rule.getValue(); // quick O(1) lookup style logic
            }
        }
        return "Sorry, I didn't understand that. Can you rephrase your question?";
    }
}
