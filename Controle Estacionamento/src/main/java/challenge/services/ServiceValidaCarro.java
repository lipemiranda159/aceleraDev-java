package challenge.services;

import challenge.Carro;
import challenge.Motorista;

public class ServiceValidaCarro {

    private static boolean PossuiPlaca(Carro carro)
    {
        return !carro.getPlaca().isEmpty();
    }

    private static boolean PossuiCor(Carro carro)
    {
        return !carro.getCor().name().isEmpty();
    }

    public static boolean PossuiMotorista(Motorista motorista){
        return motorista != null;
    }

    public static boolean ValidaCarro(Carro carro)
    {
        return PossuiCor(carro) &&
                PossuiPlaca(carro);
    }
}
