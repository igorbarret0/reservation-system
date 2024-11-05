package com.igor.reservation_system.infrastructure.configurations;

import com.igor.reservation_system.applications.usecases.GetAllFlightsUseCase;
import com.igor.reservation_system.applications.usecases.GetFlightByIdUseCase;
import com.igor.reservation_system.applications.usecases.GetFlightsByDestinationUseCase;
import com.igor.reservation_system.applications.usecases.SaveFlightUseCase;
import com.igor.reservation_system.applications.usecases.impl.GetAllFlightUseCaseImpl;
import com.igor.reservation_system.applications.usecases.impl.GetFlightByIdUseCaseImpl;
import com.igor.reservation_system.applications.usecases.impl.GetFlightsByDestinationUseCaseImpl;
import com.igor.reservation_system.applications.usecases.impl.SaveFlightUseCaseImpl;
import com.igor.reservation_system.core.gateways.FlightGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public GetAllFlightsUseCase getAllFlightsUseCase(FlightGateway flightGateway) {
        return new GetAllFlightUseCaseImpl(flightGateway);
    }

    @Bean
    public GetFlightByIdUseCase getFlightByIdUseCase(FlightGateway flightGateway) {
        return new GetFlightByIdUseCaseImpl(flightGateway);
    }

    @Bean
    public SaveFlightUseCase saveFlightUseCase(FlightGateway flightGateway) {
        return new SaveFlightUseCaseImpl(flightGateway);
    }

    @Bean
    public GetFlightsByDestinationUseCase getFlightsByDestinationUseCase(FlightGateway flightGateway) {
        return new GetFlightsByDestinationUseCaseImpl(flightGateway);
    }

}
