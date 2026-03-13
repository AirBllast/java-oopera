public class MusicalShow extends Show {
    private Person musicAuthor;
    private String librettoText;

    public MusicalShow(String title,
                       int duration,
                       Director director,
                       Person musicAuthor,
                       String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public String getLibrettoText() {

        return librettoText;
    }

    @Override
    public void printlibrettoText() {

        System.out.println("Либретто: " + getLibrettoText());
    }

}


