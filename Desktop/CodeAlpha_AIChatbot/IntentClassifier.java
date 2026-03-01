import java.util.*;

public class IntentClassifier {

    private Map<String, List<String>> intentKeywords;

    public IntentClassifier() {

        intentKeywords = new HashMap<>();

        intentKeywords.put("greeting",
                Arrays.asList("hello", "hi", "hey"));

        intentKeywords.put("admission",
                Arrays.asList("admission", "apply", "enroll"));

        intentKeywords.put("fees",
                Arrays.asList("fee", "cost", "price"));

        intentKeywords.put("courses",
                Arrays.asList("course", "program", "subject"));

        intentKeywords.put("location",
                Arrays.asList("location", "campus", "address"));

        // NEW INTENTS
        intentKeywords.put("health",
                Arrays.asList("headache", "fever", "pain", "sick"));

        intentKeywords.put("assignment",
                Arrays.asList("assignment", "homework", "project", "doubt"));

        intentKeywords.put("confused",
                Arrays.asList("what", "?", "why"));
        intentKeywords.put("smalltalk",
        Arrays.asList("how", "are", "you", "doing"));

intentKeywords.put("thanks",
        Arrays.asList("thanks", "thank", "thankyou"));
    }

    public String detectIntent(String[] tokens) {

        Map<String, Integer> scores = new HashMap<>();

        for (String token : tokens) {
            for (String intent : intentKeywords.keySet()) {
                if (intentKeywords.get(intent).contains(token)) {
                    scores.put(intent,
                            scores.getOrDefault(intent, 0) + 1);
                }
            }
        }

        return scores.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("unknown");
    }
}