/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.mp.tech.test.model.util;

/**
 *
 * @author diego
 */
public class DefaultResponseUtil {

    // =========================================================== CODIGOS DE RESPUESTA POSITIVA
    public static final MessageResult OK_UPDATE
            = new MessageResult("OR001", "CAMBIOS APLICADOS");

    public static final MessageResult OK_REGISTER
            = new MessageResult("OR001", "SEDE REGISTRADA");

    public static String UPDATE_MSSG = "SE HA ACTUALIZADO CORRECTAMENTE LA SEDE";

    // =========================================================== CODIGOS DE ERROR
    public static final MessageResult INVALID_BODY
            = new MessageResult("FEC001", "LA ESTRUCTURA DEL CUERPO NO ES LA CORRECTA");

    public static final MessageResult HEADQUARTER_REGISTERED
            = new MessageResult("EC001", "LA SEDE YA ESTÁ REGISTRADO");

    public static final MessageResult NO_EADQUARTER
            = new MessageResult("EC001", "LA SEDE NO ESTÁ REGISTRADA");

    public static final MessageResult SERVER_ERROR
            = new MessageResult("IEC001", "SE PRODUJO UN ERROR EN EL SERVIDOR");

    public static String ERROR_CODE = "EC002";

}
