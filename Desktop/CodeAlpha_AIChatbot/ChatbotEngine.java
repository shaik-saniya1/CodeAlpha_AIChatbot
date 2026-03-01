import java.util.*;

public class ChatbotEngine {

    private IntentClassifier classifier;
    private FAQRepository repository;

    private String lastIntent = "";   // Conversation memory

    public ChatbotEngine() {
        classifier = new IntentClassifier();
        repository = new FAQRepository();
    }

    public String getResponse(String userInput) {

        if (userInput == null || userInput.trim().isEmpty()) {
            return "Please enter a message.";
        }

        String lowerInput = userInput.toLowerCase();

        // Basic NLP Tokenization
        String[] tokens = lowerInput.split("\\s+");

        String intent = classifier.detectIntent(tokens);

        // 🔹 Context Handling
        if (intent.equals("unknown") && !lastIntent.isEmpty()) {

            if (lastIntent.equals("assignment")) {
                return "You mentioned " + userInput +
                        ". What exactly is your doubt in this subject?";
            }

            if (lastIntent.equals("health")) {
                return "Can you describe your symptoms more clearly?";
            }
        }

        lastIntent = intent;

        return repository.getAnswer(intent);
    }
}