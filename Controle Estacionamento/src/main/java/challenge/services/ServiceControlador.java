package challenge.services;

import challenge.Carro;
import challenge.NaoTemVagaException;

import java.util.ArrayList;

public class ServiceControlador {
    private final ArrayList<Carro> CarrosEstacionados;

    public ServiceControlador() {
        CarrosEstacionados = new ArrayList<Carro>();
    }

    private boolean AindaTemEspaço()
    {
        if (CarrosEstacionados.size() < 10)
        {
            return true;
        } else return false;
    }

    private void RemoveCarro(){
        boolean carroRemovido = false;
        int position = 0;
        while (!carroRemovido && position < CarrosEstacionados.size())
        {
            Carro carro = CarrosEstacionados.get(position);
            if (carro.getMotorista().getIdade() < 55) {
                CarrosEstacionados.remove(carro);
                carroRemovido = true;
            } else {
                position++;
            }
        }
        if (!carroRemovido)
        {
            throw new NaoTemVagaException("Estacionamento sem vagas no momento");
        }
    }

    public int RetornaNumeroCarrosEstacionados()
    {
        return CarrosEstacionados.size();
    }

    public boolean CarroEstacionado(Carro carro)
    {
        return CarrosEstacionados
                .stream().anyMatch(c ->
                        c.equals(carro) &&
                                c.getMotorista().equals(carro.getMotorista()));
    }

    public void Estacionar(Carro carro)
    {
        ServiceValidaMotorista.VerificaPermissaoEstacionar(carro);
        if (!AindaTemEspaço()) {
            RemoveCarro();
        }
        CarrosEstacionados.add(carro);
    }



}
