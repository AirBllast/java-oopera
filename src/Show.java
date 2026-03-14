import java.util.ArrayList;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors = new ArrayList<>();


    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }

    public void printDirectorInf() {

        System.out.println(director);
    }

    public void printListOfActors() {
        if (this.listOfActors.isEmpty()) {
            System.out.println("У этого шоу еще нет актеров.");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println(actor);
            }
        }
    }

    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Этот актер уже участвует в шоу.");
            return;
        }
        listOfActors.add(actor);
        System.out.println("Актер успешно добавлен.");
    }

    public void changeActor(Actor actor, String previousActorSurname) {
        if (listOfActors.contains(actor)) {
            System.out.println("Актер " + actor.getSurname() + " уже и так участвует в этом шоу.");
            return;
        }

        boolean found = false;
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor currentActor = listOfActors.get(i);

            if (currentActor.getSurname().equals(previousActorSurname)) {
                String oldSurname = currentActor.getSurname();
                listOfActors.set(i, actor);
                System.out.println("Актер " + actor.getSurname() + " теперь исполняет роль " + oldSurname + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Актера с фамилией " + previousActorSurname + " нет в этом шоу.");
        }
    }

    public void printlibrettoText() {

        System.out.println("У этого шоу нет либретто.");
    }
}
