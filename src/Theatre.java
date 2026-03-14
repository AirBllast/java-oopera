import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Actor petrovIvan = new Actor("Иван", "Петров", Gender.MALE, 180);
        Actor orlovaMariya = new Actor("Мария", "Орлова", Gender.FEMALE, 165);
        Actor pakAndrey = new Actor("Андрей", "Пак", Gender.MALE, 190);
        Director volkovSergey = new Director("Сергей", "Волков", Gender.MALE, 5);
        Director kuznecovaAnna = new Director("Анна", "Кузнецова", Gender.FEMALE, 3);
        Person romanovAlexMusicAuthor = new Person("Алексей", "Романов", Gender.MALE);
        Person savickayaElenaChoreographer = new Person("Елена", "Савицкая", Gender.FEMALE);
        ArrayList<Actor> troupe = new ArrayList<>();
        troupe.add(petrovIvan);
        troupe.add(orlovaMariya);
        troupe.add(pakAndrey);
        Show shadows = new Show("Тени", 75, volkovSergey);
        shadows.addActor(petrovIvan);
        shadows.addActor(orlovaMariya);
        Opera voice = new Opera("Голос", 120, kuznecovaAnna, romanovAlexMusicAuthor,
                "АааААааАаа", 15);
        voice.addActor(pakAndrey);
        voice.addActor(orlovaMariya);
        Ballet aurora = new Ballet("Аврора", 50, volkovSergey, romanovAlexMusicAuthor,
                "ОооооООо", savickayaElenaChoreographer);
        aurora.addActor(petrovIvan);
        aurora.addActor(orlovaMariya);
        aurora.addActor(pakAndrey);

        while (true) {
            System.out.println("Выберите шоу или команду 'Выход':");
            System.out.println("1. Шоу Тени");
            System.out.println("2. Опера Голос");
            System.out.println("3. Балет Аврора");
            System.out.println("4. Выход");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showMenu(shadows, scanner, troupe);
                    break;
                case 2:
                    showMenu(voice, scanner, troupe);
                    break;
                case 3:
                    showMenu(aurora, scanner, troupe);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Такой команды нет");
                    break;
            }
        }
    }


    static void showMenu(Show show, Scanner scanner, ArrayList<Actor> troupe) {
        System.out.println("1. Узнать режиссера");
        System.out.println("2. Список актеров");
        System.out.println("3. Либретто");
        System.out.println("4. Добавить актера");
        System.out.println("5. Заменить актера");
        int cmd = scanner.nextInt();
        switch (cmd) {
            case 1:
                show.printDirectorInf();
                break;
            case 2:
                show.printListOfActors();
                break;
            case 3:
                show.printlibrettoText();
                break;
            case 4:
                show.addActor(createActor(scanner));
                break;
            case 5:
                if (show.listOfActors.isEmpty()) {
                    System.out.println("В шоу пока нет актеров для замены.");
                } else {
                    System.out.println("Выберите номер актера, которого хотите добавить:");

                    for (int i = 0; i < troupe.size(); i++) {
                        System.out.println((i + 1) + ". " + troupe.get(i));
                    }

                    int actorIndex = scanner.nextInt() - 1;

                    if (actorIndex >= 0 && actorIndex < troupe.size()) {
                        Actor actor = troupe.get(actorIndex);
                        System.out.println("Сейчас в спектакле участвуют следующие актеры: ");
                        show.printListOfActors();
                        System.out.println("Введите фамилию актера которого нужно заменить:");
                        String actorSurname = scanner.next();
                        show.changeActor(actor, actorSurname);
                    } else {
                        System.out.println("Неверный номер актера.");
                    }
                }
                break;
            default:
                System.out.println("Такой команды нет.");
                break;
        }

    }

    private static Actor createActor(Scanner scanner) {

        System.out.println("Введите имя:");
        String name = scanner.next();

        System.out.println("Введите фамилию:");
        String surname = scanner.next();

        System.out.println("Введите рост:");
        double height = scanner.nextDouble();

        int genderChoice;
        while (true) {
            System.out.println("Выберите пол:");
            System.out.println("1. Мужской");
            System.out.println("2. Женский");

            genderChoice = scanner.nextInt();

            if (genderChoice == 1 || genderChoice == 2) {
                break;
            }
            System.out.println("Неверный ввод. Попробуйте снова.");
        }
        Gender gender;

        if (genderChoice == 1) {
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }

        return new Actor(name, surname, gender, height);
    }
}

