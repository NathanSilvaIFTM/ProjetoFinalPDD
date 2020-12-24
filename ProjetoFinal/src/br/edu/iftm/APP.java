package br.edu.iftm;


public class APP {

    public static void main(String[] args)  {
        if (args.length == 0) {
            System.err.print("Voce precisa informar uma Hash como argumento!");
            System.exit(-1);
        }
        String senhaHash = args[0];
        Cracker getResult = new Cracker();
        Cracker t1 = new Cracker(1,senhaHash);
        Cracker t2 = new Cracker(2,senhaHash);
        Cracker t3 = new Cracker(3,senhaHash);
        Cracker t4 = new Cracker(4,senhaHash);
        Cracker t5 = new Cracker(5,senhaHash);
        Cracker t6 = new Cracker(6,senhaHash);
        t1.run();
        t2.run();
        t3.run();
        t4.run();
        t5.run();
        t6.run();
        if (getResult.achouSenha()) {
            System.out.print(getResult.senhaEncontrada());
            System.out.println("\nSenha Encontrada");
            System.exit(0);
        } else {
            System.err.print("Senha nao encontrada.");
            System.exit(-1);
        }
    }
}
