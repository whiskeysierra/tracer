package org.zalando.opentracing.jdbc.span;

import io.opentracing.Span;
import org.apiguardian.api.API;

import java.sql.Statement;

import static io.opentracing.log.Fields.MESSAGE;
import static java.util.Collections.singletonMap;
import static org.apiguardian.api.API.Status.EXPERIMENTAL;

/**
 * Sets the <code>message</code> span log.
 *
 * @see <a href="https://opentracing.io/specification/conventions/#log-fields-table">Standard Log Fields</a>
 */
@API(status = EXPERIMENTAL)
public final class ErrorMessageSpanDecorator implements SpanDecorator {

    @Override
    public void onError(
            final Span span,
            final Statement statement,
            final Throwable error) {

        span.log(singletonMap(MESSAGE, error.getMessage()));
    }

}
