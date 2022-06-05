package de.zeller.spockexample.task.e2e

import de.zeller.spockexample.SpockExampleApplication
import geb.spock.GebSpec
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import spock.lang.AutoCleanup
import spock.lang.Shared

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class BaseGebSpec extends GebSpec {

    @Shared
    @AutoCleanup
    ConfigurableApplicationContext context

    void setupSpec() {
        Future future = Executors.newSingleThreadExecutor().submit(
                new Callable() {
                    @Override
                    ConfigurableApplicationContext call() throws Exception {
                        return (ConfigurableApplicationContext) SpringApplication
                                .run(SpockExampleApplication.class)
                    }
                })
        context = future.get(60, TimeUnit.SECONDS) as ConfigurableApplicationContext
    }
}
