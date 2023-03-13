package util;

import service.impl.BookServiceImpl;

import java.util.List;

public class Menu {
    public static int homePage() {
        System.out.println("---------| Home Page |---------");
        System.out.println("""
                0.Exit
                1.Edit book
                2.Show book
                3.Sort the books""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static int editPage() {
        System.out.println("---------| Edit Book |---------");
        System.out.println("""
                1.Add book
                2.Update book
                3.Remove book""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static int showPage() {
        System.out.println("---------| Show Book |---------");
        System.out.println("""
                1.Show by name
                2.Show all books""");
        return InputUtil.requiredInputInt("Choose option: ");
    }
    public static int sortPage() {
        System.out.println("---------| Sort Book |---------");
        System.out.println("""
                1.Sort by date
                2.Sort by name""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static void start() {
        BookServiceImpl bookService = new BookServiceImpl();
        while (true) {
            int choose = homePage();
            if (choose == 0) {
                System.exit(-1);
            } else if (choose == 1) {
                int a = editPage();
                if (a == 1) {
                    bookService.addBook();
                } else if (a == 2) {
                    bookService.updateBook();
                } else if (a==3){
                    bookService.removeBook();
                }else {
                    System.out.println("Wrong option!!!");
                }
            } else if (choose == 2) {
                int a = showPage();
                if (a == 1) {
                    System.out.println("---------------");
                    List liste=bookService.showByName();
                    if (liste!=null){
                        liste.forEach(i-> System.out.println(i.toString()));
                    }
                    System.out.println("---------------");
                } else if (a == 2) {
                    System.out.println("---------------");
                    bookService.showAllBook().forEach(i-> System.out.println(i.toString()));
                    System.out.println("---------------");
                } else {
                    System.out.println("Wrong option!!!");
                }
            }else if (choose==3){
                int a = sortPage();
                if (a == 1) {
                    System.out.println("---------------");
                    bookService.sortByDate().forEach(i-> System.out.println(i.toString()));
                    System.out.println("---------------");
                } else if (a == 2) {
                    System.out.println("---------------");
                    bookService.sortByName().forEach(i-> System.out.println(i.toString()));
                    System.out.println("---------------");
                } else {
                    System.out.println("Wrong option!!!");
                }
            }else {
                System.out.println("Wrong oprion!!!");
            }
        }
    }
}

