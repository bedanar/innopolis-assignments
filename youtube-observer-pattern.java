package ssad.ass5;

import java.util.ArrayList;
import java.util.List;

class Runner {
    public static void main(String args[]) {
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        Channel channel1 = new Channel("Discovery");
        Channel channel2 = new Channel("Pewdiepie");
        Channel channel3 = new Channel("Innopolis");

        channel1.subscribe(user1);
        channel2.subscribe(user2);
        channel3.subscribe(user1);
        channel3.subscribe(user2);

        channel1.publish(new Video("Animals in Australia"));
        channel2.publish(new Shorts("Minecraft"));
        channel3.publish(new LiveStream("Report from rainforests"));

        channel3.unsubscribe(user1);

        channel1.publish(new Video("Scuba Diving in Great Barrier Reef"));
        channel2.publish(new Shorts("Fortnite montage"));
        channel3.publish(new LiveStream("Jungle survival tips"));
    }
}

interface Subject {
    public void subscribe(Observer user);
    public void publish(Content content);
    public void unsubscribe(Observer user);
}

class Channel implements Subject {
    protected String name;
    protected List<Observer> users = new ArrayList<>();

    public Channel(String name) {
        this.name = name;
    }

    public void subscribe(Observer user) {
        this.users.add(user);
    }
    public void publish(Content content) {
        for (Observer user : users) {
            user.update(content, name);
        }
    }
    public void unsubscribe(Observer user) {
        this.users.remove(user);
    }
}

interface Observer {
    public void update(Content content, String name);
}

class User implements Observer {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public void update(Content content, String chname) {
        String className = content.getClass().getSimpleName();
        System.out.println(name + ": Channel " + chname + (className.equals("LiveStream") ? " is going live: " + content.getName() : " published new " + className + ": " + content.getName()));
    }
}

interface Content {
    public String getName();
    public double getDuration();
    public void like();
    public void dislike();
}

class Video implements Content {
    protected String name;
    protected double duration;
    protected boolean isLiked = false;

    public Video(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public void like() {
        isLiked = true;
    }

    public void dislike() {
        isLiked = false;
    }
}

class Shorts implements Content {
    protected String name;
    protected double duration;
    protected boolean isLiked = false;

    public Shorts(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public void like() {
        isLiked = true;
    }

    public void dislike() {
        isLiked = false;
    }
}

class LiveStream implements Content {
    protected String name;
    protected double duration;
    protected boolean isLiked = false;

    public LiveStream(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public void like() {
        isLiked = true;
    }

    public void dislike() {
        isLiked = false;
    }
}


// Output
// Alice: Channel Discovery published new Video: Animals in Australia
// Bob: Channel Pewdiepie published new Shorts: Minecraft
// Alice: Channel Innopolis is going live: Report from rainforests
// Bob: Channel Innopolis is going live: Report from rainforests
// Alice: Channel Discovery published new Video: Scuba Diving in Great Barrier Reef
// Bob: Channel Pewdiepie published new Shorts: Fortnite montage
// Bob: Channel Innopolis is going live: Jungle survival tips
