class College {
    String name = "VIT";
    private ranking = 3;
}

class Main() {
    public static void main(String args[]) {
        College c = new College();
        c.name;     // Accessible
        c.ranking;  // Will throw error, not Accessible
    }
}
