import java.util.HashMap;
import java.util.Map;

public class FAQRepository {

    private Map<String, String> responses;

    public FAQRepository() {

        responses = new HashMap<>();

        responses.put("greeting",
                "Hello! How can I assist you today?");

        responses.put("admission",
                "Admissions are open from June to August.");

        responses.put("fees",
                "The fee structure depends on the selected program.");

        responses.put("courses",
                "We offer various undergraduate and postgraduate programs.");

        responses.put("location",
                "Our campus is located in New York City.");

        responses.put("health",
                "If you have a headache, please take rest, stay hydrated, and consult a doctor if pain persists.");

        responses.put("assignment",
                "Please tell me your assignment topic. I’ll try to help you.");

        responses.put("confused",
                "Could you please clarify your question so I can assist you better?");

        responses.put("unknown",
                "I'm sorry, I didn't understand that. Could you rephrase?");
        responses.put("smalltalk",
        "I'm doing great! How can I help you today?");
        responses.put("thanks",
        "You're welcome! Let me know if you need anything else.");
    }  

    public String getAnswer(String intent) {
        return responses.getOrDefault(intent, responses.get("unknown"));
    }
}