package Model;

import java.io.Serializable;

public class Survey implements Serializable {
    public Survey()
    {

    }

    public int getClientNumber() {
        return clientNumber;
    }

    public int getTrans_type() {
        return trans_type;
    }

    public int getNumberofkm() {
        return numberofkm;
    }

    int clientNumber = 0;
    int trans_type = 0;
    int numberofkm = 0;

    public Survey(int clientnumber, int trans_type, int numberofkm)
    {
        this.clientNumber = clientnumber;

        if (trans_type == 1)
            this.trans_type = 1;
        else if (trans_type == 2)
            this.trans_type = 2;
        else if (trans_type == 3)
            this.trans_type = 3;
        else if (trans_type == 4)
            this.trans_type = 4;

        this.numberofkm = numberofkm;

    }

    @Override
    public String toString() {
        if(trans_type == 1)
        return "Client Number = " + clientNumber +
                ", Trans_Type = Bus" +
                ", Number of km = " + numberofkm;
        else if (trans_type == 2)
            return "Client Number = " + clientNumber +
                    ", Trans_Type = Metro" +
                    ", Number of km = " + numberofkm;
        else if (trans_type == 3)
            return "Client Number = " + clientNumber +
                    ", Trans_Type = Private Transport" +
                    ", Number of km = " + numberofkm
                   ;
        else
            return "clientNumber = " + clientNumber +
                    ", Trans_Type = Taxi" +
                    ", numberofkm = " + numberofkm
                    ;

    }
}
