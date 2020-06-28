package challenge.services;

import challenge.MotoristaInvalidoException;
import challenge.Carro;
import challenge.Motorista;

public class ServiceValidaMotorista {

    private static final int IDADE_MINIMA = 18;
    private static final int PONTUACAO_MINIMA = 20;


    public static void TemIdadeSuficiente(int idade)
    {
        if (idade < 0)
        {
            throw new IllegalArgumentException("Idade menor do que zero!");
        } else if (idade < IDADE_MINIMA)
        {
            throw new NullPointerException("Idade não permitida");
        }
    }

    public static boolean TemHabilitacao(Motorista motorista)
    {

        return !motorista.getHabilitacao().isEmpty();
    }

    public static boolean PontuacaoValida(int pontos)
    {
        if (pontos < 0)
        {
            throw new IllegalArgumentException("Pontos negativos");
        }

        return pontos >= 0 && pontos <= PONTUACAO_MINIMA;
    }

    public static boolean ValidaNome(Motorista motorista)
    {
        return !motorista.getNome().isEmpty();
    }

    public static boolean ValidaMotorista(Motorista motorista)
    {
        return ValidaNome(motorista) &&
                TemHabilitacao(motorista);
    }

    public static void VerificaPermissaoEstacionar(Carro carro) {
        Motorista motorista = carro.getMotorista();
        String error = "";
        if (!ServiceValidaCarro.PossuiMotorista(motorista))
        {
            error = "Carro autonomo não permitido";
        } else if (!ServiceValidaMotorista.PontuacaoValida(motorista.getPontos()))
        {
            error = "Motorista invalido";
        }
        try
        {
            TemIdadeSuficiente(motorista.getIdade());
        } catch(NullPointerException ex)
        {
            throw new MotoristaInvalidoException("Motorista invalido");
        }

        if (!error.isEmpty())
        {
            throw new MotoristaInvalidoException(error);
        }
    }


    public static void ValidaIdadeNegativa(int idade) {
        if (idade < 0)
            throw new IllegalArgumentException("Idade inválida");
    }
}
