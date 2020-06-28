package challenge;

import challenge.services.ServiceControlador;

public class Estacionamento {

    private final ServiceControlador serviceControlador;

    public Estacionamento() {
        serviceControlador = new ServiceControlador();
    }

    public void estacionar(Carro carro) {
      serviceControlador.Estacionar(carro);
    }

    public int carrosEstacionados() {
         return serviceControlador.RetornaNumeroCarrosEstacionados();
    }

    public boolean carroEstacionado(Carro carro) {
        return serviceControlador.CarroEstacionado(carro);
    }
}
