package net.moddity.droidnubekit.errors;

import android.util.Log;

import net.moddity.droidnubekit.DroidNubeKit;
import net.moddity.droidnubekit.responsemodels.DNKUnauthorizedResponse;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Created by jaume on 12/6/15.
 */
public class DNKErrorHandler implements ErrorHandler {

    private final DroidNubeKit kit;

    public DNKErrorHandler(DroidNubeKit kit) {
        this.kit = kit;
    }

    @Override
    public Throwable handleError(RetrofitError cause) {

        if(cause.getResponse() == null) //No connection¿? //todo improve this
            return createException(cause);

        switch (cause.getResponse().getStatus()) {
            case DNKErrorCodes.AUTHENTICATION_REQUIRED:
                DNKUnauthorizedResponse errorResponse = (DNKUnauthorizedResponse)cause.getBodyAs(DNKUnauthorizedResponse.class);

                Log.i("CK", "open auth page at: " + errorResponse.getRedirectURL());
                kit.showAuthDialog(errorResponse.getRedirectURL());

                return new DNKAuthenticationRequiredException(DNKErrorCodes.AUTHENTICATION_REQUIRED, cause.getCause(), errorResponse);

            default:
                return createException(cause);
        }
    }

    private DNKException createException(RetrofitError cause) {
        DNKException exception = new DNKException(cause.getResponse().getStatus(), cause.getCause());
        return exception;
    }
}
