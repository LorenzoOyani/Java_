package org.example.chart.client;

public enum Commands {
    QUIT("user to exit chat by typing /quit"),
    LIST("List all the connected client by typing /list"),
    WHISPER("\"Send a message to a specific user by typing /whisper <username> <message>.\""),
    NAME("\"change your displayed name by typing /name <new-username>\""),
    HELP("List all available commands by typing /help");
    private String description;
    Commands(String description) {
        this.description = description;

    }

    public String getDescription() {
        return description;

    }

}
