package uk.co.cacoethes.handlebars

import groovy.text.Template

/**
 * Implementation of {@code groovy.text.Template} for Handlebars
 *
 * @author andyjduncan
 */
class HandlebarsTemplate implements Template {

    private final nativeTemplate

    HandlebarsTemplate(final com.github.jknack.handlebars.Template nativeTemplate) {
        this.nativeTemplate = nativeTemplate
    }

    @Override
    Writable make() {
        make [:]
    }

    @Override
    Writable make(final Map binding) {
        { Writer destination ->
            nativeTemplate.apply(binding, destination)
            destination.flush()
            destination
        } as Writable
    }
}
