package ru.vsu.lab.store.view;

/**
 * Класс представление для взаимодействия с пользователем
 */
//public class PeopleView {
//    /** Поле сканер*/
//    private static Scanner in = new Scanner(System.in);
//    /**Поле хранилище*/
//    private Repository repository;
//
//    /**
//     * Конструктор без параметров
//     */
//    public PeopleView() throws NoSuchFieldException {
//        this.repository = new Repository();
//    }
//
//    /**
//     * Метод для взаимодействия с пользователем
//     */
//    public void show() throws ParseException, NoEntityException {
//        while (true) {
//            System.out.println("enter 0 to show all");
//            System.out.println("enter 1 to add");
//            System.out.println("enter 2 to delete by id");
//            System.out.println("enter 3 to update");
//            System.out.println("enter 4 to get by id");
//
//            int action=in.nextInt();
//            switch (action) {
//                case 0: {
//                    Person [] people = repository.getAll();
//                    for (Person p:people)
//                        System.out.println(p.toString());
//                    break;
//                }
//                case 1: {
//                    System.out.println("enter id");
//                    int id = in.nextInt();
//                    System.out.println("enter name");
//                    String name = in.next();
//                    System.out.println("enter surname");
//                    String surname = in.next();
////                    Data data=in.next();
//                    System.out.println("enter sex");
//                    String sex = in.next();
//                    System.out.println("enter birthday");
//                    String dateTime=in.next();
//                    //String dateTime = "11/15/2013";
//                    DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");
//                    LocalDate jodatime = dtf.parseLocalDate(dateTime);
//
//                    Person person=new Person((long)id, name, surname, jodatime, sex);
//                    repository.add(person);
//                    break;
//                }
//                case 2: {
//                    System.out.println("enter id");
//                    int id = in.nextInt();
//                    repository.deleteById((long)id);
//                    break;
//                }
//                case 3: {
//                    System.out.println("enter id");
//                    int id = in.nextInt();
//                    System.out.println("enter name");
//                    String name = in.next();
//                    System.out.println("enter surname");
//                    String surname = in.next();
//                    System.out.println("enter sex");
//                    String sex = in.next();
//                    System.out.println("enter birthday");
//                    String dateTime=in.next();
//                    //String dateTime = "11/15/2013";
//                    DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");
//                    LocalDate jodatime = dtf.parseLocalDate(dateTime);
//
//                    Person person=new Person((long)id, name, surname, jodatime, sex);
//                    repository.update(person);
//                    break;
//                }
//                case 4:{
//                    System.out.println("enter id");
//                    int id = in.nextInt();
//                    repository.getById((long)id);
//                    break;
//                }
//                case 10:{
//                    System.exit(10);
//                }
//            }
//        }
//    }
//
//}
