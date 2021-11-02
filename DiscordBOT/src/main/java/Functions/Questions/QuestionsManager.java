package Functions.Questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionsManager {
    private Map<String, String> questions = new HashMap<>();

    public QuestionsManager() {
    }

    public void addQuestions(String question, String response) {
        questions.put(question, response);
    }

    public void removeQuestions(String question) {
        questions.remove(question);
    }

    public void modifyResponse(String question, String modifier) {
        if (questions.containsKey(question)) {
            questions.replace(question, modifier);
        } else {
            System.out.println("Key doesn't exists!");
        }
    }

    public boolean verifyResponse(String question, String response) {
        if (questions.get(question).equalsIgnoreCase(response)) {
            return true;
        } else {
            return false;
        }
    }

    public String getResponse(String question) {
        if (questions.containsKey(question)) {
            return questions.get(question);
        } else {
            return "";
        }
    }

    public List<String> getQuestions() {
        return questions.values().stream().toList();
    }
}
