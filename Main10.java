import java.util.*;

class Video {
    String title;
    String url;
    int views;
    int likes;
    int dislikes;
    List<Comment> comments;

    public Video(String title, String url, int views, int likes, int dislikes, List<Comment> comments) {
        this.title = title;
        this.url = url;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
    }
}

class Comment {
    String text;
    int likes;
    int dislikes;

    public Comment(String text, int likes, int dislikes) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
    }
}

class Videoblog {
    String bloggerName;
    List<Video> videos;

    public Videoblog(String bloggerName, List<Video> videos) {
        this.bloggerName = bloggerName;
        this.videos = videos;
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення тестових даних
        List<Comment> comments1 = Arrays.asList(
                new Comment("Great video!", 10, 0),
                new Comment("Not bad", 5, 1)
        );
        List<Comment> comments2 = Arrays.asList(
                new Comment("I disagree", 2, 10),
                new Comment("Loved it!", 15, 0)
        );

        Video video1 = new Video("Java Basics", "http://example.com/java1", 1000, 100, 5, comments1);
        Video video2 = new Video("Advanced Java", "http://example.com/java2", 2000, 150, 10, comments2);

        Videoblog blog = new Videoblog("TechBlogger", Arrays.asList(video1, video2));

        // Завдання 1: Загальна кількість переглядів
        int totalViews = 0;
        for (Video video : blog.videos) {
            totalViews += video.views;
        }
        System.out.println("Загальна кількість переглядів: " + totalViews);

        // Завдання 2: Чи є коментар, що має більше лайків, ніж відео
        boolean commentHasMoreLikes = false;
        outerLoop:
        for (Video video : blog.videos) {
            for (Comment comment : video.comments) {
                if (comment.likes > video.likes) {
                    commentHasMoreLikes = true;
                    break outerLoop;
                }
            }
        }
        System.out.println("Чи є коментар з більшою кількістю лайків, ніж у відео? " + commentHasMoreLikes);

        // Завдання 3: Відео з найбільшою кількістю дизлайків
        List<Video> mostDislikedVideos = new ArrayList<>();
        int maxDislikes = 0;
        for (Video video : blog.videos) {
            if (video.dislikes > maxDislikes) {
                maxDislikes = video.dislikes;
                mostDislikedVideos.clear();
                mostDislikedVideos.add(video);
            } else if (video.dislikes == maxDislikes) {
                mostDislikedVideos.add(video);
            }
        }
        System.out.println("Відео з найбільшою кількістю дизлайків:");
        if (mostDislikedVideos.isEmpty()) {
            System.out.println("Немає таких відео.");
        } else {
            for (Video video : mostDislikedVideos) {
                System.out.println(video.title + " (" + video.url + ")");
            }
        }
    }
}
