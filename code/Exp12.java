import java.util.Scanner;

class Video {
    String title;
    boolean isCheckedOut;
    int rating;

    public Video(String title) {
        this.title = title;
        isCheckedOut = false;
        rating = 0;
    }
}

class VideoStore {
    Video[] videos;

    public VideoStore() {
        videos = new Video[10];
    }

    public void addVideo(String title) {
        Video video = new Video(title);
        for (int i = 0; i < videos.length; i++) {
            if (videos[i] == null) {
                videos[i] = video;
                System.out.println("Video added successfully: " + title);
                return;
            }
        }
        System.out.println("Video store is full. Cannot add more videos.");
    }

    public void checkOutVideo(String title) {
        for (Video video : videos) {
            if (video != null && video.title.equalsIgnoreCase(title)) {
                if (!video.isCheckedOut) {
                    video.isCheckedOut = true;
                    System.out.println("Video checked out successfully: " + title);
                } else {
                    System.out.println("Video is already checked out: " + title);
                }
                return;
            }
        }
        System.out.println("Video not found: " + title);
    }

    public void returnVideo(String title) {
        for (Video video : videos) {
            if (video != null && video.title.equalsIgnoreCase(title)) {
                if (video.isCheckedOut) {
                    video.isCheckedOut = false;
                    System.out.println("Video returned successfully: " + title);
                } else {
                    System.out.println("Video is not checked out: " + title);
                }
                return;
            }
        }
        System.out.println("Video not found: " + title);
    }

    public void receiveRating(String title, int rating) {
        for (Video video : videos) {
            if (video != null && video.title.equalsIgnoreCase(title)) {
                if (rating >= 1 && rating <= 5) {
                    video.rating = rating;
                    System.out.println("Rating added successfully for " + title + ": " + rating);
                } else {
                    System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
                }
                return;
            }
        }
        System.out.println("Video not found: " + title);
    }

    public void listInventory() {
        System.out.println("Video Inventory:");
        for (Video video : videos) {
            if (video != null) {
                System.out.println("Title: " + video.title +
                        ", Checked Out: " + (video.isCheckedOut ? "Yes" : "No") +
                        ", Rating: " + video.rating);
            }
        }
    }
}

public class Exp12{
    public static void main(String[] args) {
        VideoStore videoStore = new VideoStore();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Videos");
            System.out.println("2. Check Out Videos");
            System.out.println("3. Return Videos");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter video title to add:");
                    scanner.nextLine();
                    String addTitle = scanner.nextLine();
                    videoStore.addVideo(addTitle);
                    break;
                case 2:
                    System.out.println("Enter video title to check out:");
                    scanner.nextLine();
                    String checkOutTitle = scanner.nextLine();
                    videoStore.checkOutVideo(checkOutTitle);
                    break;
                case 3:
                    System.out.println("Enter video title to return:");
                    scanner.nextLine();
                    String returnTitle = scanner.nextLine();
                    videoStore.returnVideo(returnTitle);
                    break;
                case 4:
                    System.out.println("Enter video title to receive rating:");
                    scanner.nextLine();
                    String ratingTitle = scanner.nextLine();
                    System.out.println("Enter rating (1-5):");
                    int rating = scanner.nextInt();
                    videoStore.receiveRating(ratingTitle, rating);
                    break;
                case 5:
                    videoStore.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

