class Student {
    String name;
    double score;
    boolean passed;

    Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    void checkPassed() {
        if (score >= 70) {
            passed = true;
        } else {
            passed = false;
        }
    }
}