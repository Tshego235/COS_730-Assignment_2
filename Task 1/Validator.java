
class Validator {

    // SubmissionController → Validator] validateFormat(data) : valid/invalid
    public boolean validateFormat(String data) {
        CallTracker.record();
        return data != null && !data.trim().isEmpty();
    }
}