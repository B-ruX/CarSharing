import java.util.ArrayList;

public class CarSharing {
    private ArrayList<Automobile> automobili;// attributo di tipo ArrayList di oggetti di tipo Automobile
    private ArrayList<Parcheggio> parcheggi; // attributo di tipo ArrayList di oggetti di tipo Parcheggio


    public CarSharing() {

        automobili = new ArrayList<>(); // inizializzazione dell'ArrayList di automobili
        parcheggi = new ArrayList<>(); // inizializzazione dell'ArrayList di parcheggi

    }

    public void aggiungiParcheggio(String nome) { // metodo per aggiungere un parcheggio

        for(Parcheggio p : parcheggi) { // scorre parcheggi
            if(p.getNome().equals(nome)) { // se il nome del parcheggio è uguale a quello passato come parametro
                return; // esci
            }
        }

        Parcheggio p = new Parcheggio(); // crea un nuovo oggetto di tipo Parcheggio

        p.setNome(nome); // imposta il nome del parcheggio
        parcheggi.add(p); // aggiungi il parcheggio all'ArrayList di parcheggi

    }

    public void aggiungiAutomobile(String unaTarga, String unNomeParcheggio) { // metodo per aggiungere un'automobile

        for (Automobile a : automobili) { // scorre automobili
            if (a.getTarga().equals(unaTarga)) { // se la targa dell'automobile è uguale a quella passata come parametro
                return; // esci
            }
        }

        Automobile a = new Automobile(); // crea un nuovo oggetto di tipo Automobile

        a.setTarga(unaTarga); // imposta la targa dell'automobile
        a.setViaggi(0); // imposta il numero di viaggi dell'automobile a 0

        for (Parcheggio p : parcheggi) { // scorre parcheggi
            if (p.getNome().equals(unNomeParcheggio)) { // se il nome del parcheggio è uguale a quello passato come parametro
                a.setLocazione(p);
                automobili.add(a);
                return;
            }
        }

        Parcheggio p = new Parcheggio(); // crea un nuovo oggetto di tipo Parcheggio

        p.setNome(unNomeParcheggio); // imposta il nome del parcheggio
    }

    public void transito(String unaTarga, String parcheggioArrivo) { // metodo per il transito
        for (Automobile a : automobili) { // scorre automobili
            if (a.getTarga().equals(unaTarga)) { // se la targa dell'automobile è uguale a quella passata come parametro
                for (Parcheggio p : parcheggi) { // scorre parcheggi
                    if (p.getNome().equals(parcheggioArrivo)) { // se il nome del parcheggio è uguale a quello passato come parametro
                        a.setLocazione(p); // imposta la locazione dell'automobile
                        a.setViaggi(a.getViaggi() + 1); // incrementa il numero di viaggi dell'automobile
                        return;
                    }
                }
            }
        }
    }

    public int contaAutomobili(String unNomeParcheggio) { // metodo per contare le automobili in un parcheggio
        int contatore = 0;
        for (Automobile a : automobili) { // scorre automobili
            if (a.getLocazione().getNome().equals(unNomeParcheggio)) { // se il nome del parcheggio è uguale a quello passato come parametro
                contatore++; // incrementa il contatore
            }
        }
        return contatore; // ritorna il contatore
    }

    public void rimuoviAutomobile(int numeroViaggi) {
        for (Automobile a : automobili) { // scorre automobili
            if (a.getViaggi() > numeroViaggi) { // se il numero di viaggi dell'automobile è maggiore del numero passato come parametro
                automobili.remove(a); // rimuovi l'automobile
            }
        }
    }

    public String statistica() { //restituisce il nome del parcheggio avente più automobili
        int max = 0;
        String nomeParcheggio = null;
        for (Parcheggio p : parcheggi) { // scorre parcheggi
            int contatore = 0;
            for (Automobile a : automobili) { // scorre automobili
                if (a.getLocazione().getNome().equals(p.getNome())) { // se il nome del parcheggio è uguale a quello passato come parametro
                    contatore++; // incrementa il contatore
                }
            }
            if (contatore > max) { // se il contatore è maggiore del massimo
                max = contatore; // imposta il massimo al contatore
                nomeParcheggio = p.getNome(); // imposta il nome del parcheggio
            }
        }
        return nomeParcheggio; // ritorna il nome del parcheggio
    }
}
