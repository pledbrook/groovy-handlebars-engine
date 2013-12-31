# Handlebars Template Engine for Groovy

[Groovy](http://www.groovy-lang.org/) provides a set of interfaces for templating engines: Template and TemplateEngine.
This library provides implementations of those interfaces based on [Handlebars](http://handlebarsjs.com/) using the [Handlbars-Java](http://jknack.github.io/handlebars.java/) library.
If you wish to use this library, you need either the `groovy-all` or `groovy-templates` JARs on your classpath.

The initial implementation was contributed by [Andy Duncan](https://github.com/andyjduncan) to the [Lazybones](https://github.com/pledbrook/lazybones) project.

Licensed under [Apache License, version 2](http://apache.org/licenses/LICENSE-2.0.html)

## Usage

You use the library in exactly the same way you use Groovy's `SimpleTemplateEngine`:

    import uk.co.cacoethes.handlebars.HandlebarsTemplateEngine

    ...
    void processTemplate(File srcFile, File targetFile, Map model) {
        def engine = new HandlebarsTemplateEngine()
        def template = engine.createTemplate(srcFile.newReader()).make(model)
        targetFile.withWriter { writer ->
            template.writeTo(writer)
        }
    }

In the above example, `srcFile` would be the path to a standard Handlebars template.
