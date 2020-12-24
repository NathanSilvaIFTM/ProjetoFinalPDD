package br.edu.iftm;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Cracker implements Runnable{
    private final int TAMANHO;
    private final String HASH;
    private static volatile boolean achou = false;
    private static volatile StringBuilder senhaCerta;

    public Cracker(int tamanho, String hash){
        this.TAMANHO = tamanho;
        this.HASH = hash;
    }
    public Cracker(){
        this.TAMANHO = 0;
        this.HASH = "";
    }
    @Override
    public synchronized void run() {
        StringBuilder senhaTeste = new StringBuilder();
        senhaTeste.setLength(this.TAMANHO);
        try {
            this.gerador(senhaTeste,0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public synchronized void gerador(StringBuilder s, int carac) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (!achou) {
            if (carac == s.length()){
                if (Sha256.Hash.compare(s,this.HASH)){
                    senhaCerta = s;
                    achou = true;
                }
            }else{
                for (int i = 0; i < 43 && !achou; i++)  {
                    char letra = (char)(48+i);
                    s.setCharAt(carac,letra);
                    this.gerador(s,carac + 1);
                }
            }
        }
    }

    public boolean achouSenha() {
        return achou;
    }

    public StringBuilder senhaEncontrada() {
        return senhaCerta;
    }


}
