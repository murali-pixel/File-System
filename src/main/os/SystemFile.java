package main.os;

public class SystemFile extends SystemNode {
    private String content; /// for simplicity

    public SystemFile(String name) {
        super(name);
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public long getLength() {
        if (content != null) {
            return content.getBytes().length;
        }

        return 0;
    }
}