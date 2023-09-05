package app;

import entities.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //criando a lista
        List<Employer> list = new ArrayList<>();

        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();
        //Agora vou criar um for para percorrer a lista e guardar os nomes
        for (int i = 0; i < n; i++){
            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":" );
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine(); //esse next aqui pra limpar o buffer.
            String name =  sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Employer emp = new Employer(id,name,salary);
            list.add(emp);//aqui o comando para adiconar o funcionario

        }
        //aqui criando para perguntar ao usuario qual empregado vai receber aumento.
        System.out.print("Enter the employee id that will have salary increase : ");
        int idSalary = sc.nextInt();
        //aqui verificando a posição do id na lista
        Integer pos = position(list, idSalary);
        if (pos == null ){
            System.out.print("This id not exist!");
        } else {
            System.out.println("Enter the Porcentage: ");
            double percente = sc.nextDouble();
            //usando getPos para pegar o funcinoario na lista
            list.get(pos).increaseSalary(percente);
        }

        //aqui imprimendo os nomes dos funcinaios com o toString
        System.out.println();
        System.out.println("List of Employee: ");
        for (Employer emp : list){
            System.out.println(emp);
        }


        sc.close();
    }
    //aqui vou criar um metodo/função auxiliar para me ajudar a encontrar o ID do funcinairo escolhido
    public static Integer position(List<Employer> list, int id){
        for (int i=0; i< list.size(); i++){
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }
}
