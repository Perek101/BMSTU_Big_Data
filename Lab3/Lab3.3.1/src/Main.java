import java.util.Objects;

/*
Создать объект класса Дерево, используя классы Лист.
Методы: зацвести, опасть листьям, покрыться инеем, пожелтеть листьям.
 */
public class Main {
    public static void main(String[] args) {
        Tree a = new Tree("Береза", 9);
        Tree b = new Tree();
        List a1 = new List();
        List b1 = new List(5);
        a.Zacvesti();
        a.FallList();
        System.out.println(a.toString());
        System.out.println(b1.toString());
        System.out.println(a.equals(b));
        System.out.println(a1.equals(b1));
        System.out.println(a.hashCode());
        System.out.println(a1.hashCode());
    }
}
class List { //колесо
    int list;
    //пара конструкторов
    List() {
        list = 10;
    }
    @Override
    public boolean equals(Object ob)
    {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        List p = (List) ob;

        return Objects.equals(list, p.list);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(list);
    }
    @Override
    public String toString() {
        return "List{" +
                "list=" + list +
                '}';
    }

    List(int count) {
        this.list = count;
    }
}

class Tree extends List {
    String tree;   //поле класса
    Tree() { //конструктор
        super();
        tree = "Береза";
    }

    Tree(String tree, int count) {
        super(count);
        this.tree = tree;
    }
    void Zacvesti() {
        System.out.println("Зацвести");
    }
    void FallList() { //сменить колесо
        super.list = 0;
    }
    void Inei() {
        System.out.println("Покрыться инеем");
    }
    void YellowList() {
        System.out.println("Пожелтеть");
    }
    @Override
    public boolean equals(Object ob)
    {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        Tree p = (Tree) ob;

        return Objects.equals(tree, p.tree);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(tree);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "tree='" + tree + '\'' +
                ", list=" + list +
                '}';
    }
}