import java.util.ArrayList;

public class Show {
    public String title;
    public int duration;
    public Director director;
    public ArrayList<Actor> listOfActors = new ArrayList<>();


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
            System.out.println("У этого шоу еще нет актеров");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println(actor);
            }
        }
    }

    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Этот актер уже участвует в шоу");
            return;
        }
        listOfActors.add(actor);
        System.out.println("Актер успешно добавлен.");
    }

    public void changeActor(Actor oldActor, Actor newActor) {
        int index = listOfActors.indexOf(oldActor);

        if (index == -1) {
            System.out.println("Актер " + oldActor.getName() + " не найден в этом шоу");
            return;
        }

        if (newActor.getName().equals(oldActor.getName())) {
            System.out.println("Тот же актер!");
            return;
        }

        if (listOfActors.contains(newActor)) {
            System.out.println("Этот актер уже участвует в шоу");
            return;
        }

        listOfActors.set(index, newActor);
        System.out.println("Актер " + newActor.getSurname() + ' ' + newActor.getName() + " теперь исполняет роль " +
                oldActor.getSurname() + ' ' + oldActor.getName());
    }

    public void printlibrettoText() {
        System.out.println("У этого шоу нет либретто.");
    }
}
