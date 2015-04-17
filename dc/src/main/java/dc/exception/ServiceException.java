package dc.exception;

import java.io.Serializable;

/**
 * Created by evan.wan on 2015/4/16.
 */
public class ServiceException extends BaseException {

    /**
     * Constructors
     *
     * @param code
     *            错误代码
     */
    public ServiceException(String code) {
        super(code, null, code, null);
    }

    /**
     * Constructors
     *
     * @param cause
     *            异常接口
     * @param code
     *            错误代码
     */
    public ServiceException(Throwable cause, String code) {
        super(code, cause, code, null);
    }

    /**
     * Constructors
     *
     * @param code
     *            错误代码
     * @param values
     *            �?��异常信息待定参数
     */
    public ServiceException(String code, Object[] values) {
        super(code, null, code, values);
    }

    /**
     * Constructors
     *
     * @param cause
     *            异常接口
     * @param code
     *            错误代码
     * @param values
     *            �?��异常信息待定参数
     */
    public ServiceException(Throwable cause, String code, Object[] values) {
        super(code, null, code, values);
    }

    private static final long serialVersionUID = -3711290613973933714L;

}
