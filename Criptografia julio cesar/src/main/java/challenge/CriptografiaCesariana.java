package challenge;

public class CriptografiaCesariana implements Criptografia {

    private String getCriptoText(CriptoType type, String texto)
    {
        if (texto.isEmpty())
        {
            throw new IllegalArgumentException("Favor passar um texto válido!");
        }
        texto = texto.toLowerCase();
        StringBuilder result = new StringBuilder();
        char aux;
        for (int x=0;x<texto.length();x++) {
            aux = texto.charAt(x);
            if(Character.isLetter(aux))
            {
                result.append(type == CriptoType.Cript ?
                        String.valueOf(Character.toChars(aux + Constant.CRIPT_FACTOR)):
                        String.valueOf(Character.toChars(aux - Constant.CRIPT_FACTOR)));
            }else if (Character.isSpaceChar(aux) || Character.isDigit(aux)) {
                result.append(aux);
            }
        }

        return result.toString();
    }
    @Override
    public String criptografar(String texto) {
        return getCriptoText(CriptoType.Cript, texto);
    }

    @Override
    public String descriptografar(String texto) {
        return getCriptoText(CriptoType.Decript, texto);
    }

}
