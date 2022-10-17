package main.os;

import org.w3c.dom.Node;

import java.io.File;

public class SystemMain {
    public static void main(String[] args) {

        SystemDirectory root = new SystemDirectory("root");
        SystemFile file = new SystemFile("profile.jpg");
        root.add((Node) file);

        SystemDirectory movie = new SystemDirectory("movie");
        root.add((Node) movie);

        SystemDirectory englishMovie = new SystemDirectory("english");

        englishMovie.add((Node) new SystemFile("IronFist.mp4"));
        englishMovie.add((Node) new File("The Shawshank Redemption.mp4"));
        englishMovie.add((Node) new File("ZotaPia.mp4"));
        SystemFile despicableMe = new SystemFile("DespicableMe.mp4");
        englishMovie.add((Node) despicableMe);
        movie.add((Node) englishMovie);

        SystemDirectory banglaMovie = new SystemDirectory("Bangla");
        banglaMovie.add((Node) new File("The Clay Bird.mp4"));
        banglaMovie.add((Node) new File("Jibon Thekey Neya.mp4"));

        movie.add((Node) banglaMovie);

        root.printTree();

        System.out.println("name: " + movie.getName());
        System.out.println("Created: " + movie.getCreated());
    }
}
