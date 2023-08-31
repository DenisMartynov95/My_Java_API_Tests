package Pogo;

public class User { // Общий класс для всего файла JSON, он пустой,однако содержил поля которые написал в классе Data, поэтому передаю их сюда. Его всегда обязательно создавать и запихивать сюда все другие Pogo, как матрешку
    private Data data;


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
