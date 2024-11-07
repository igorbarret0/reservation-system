package com.igor.reservation_system.infrastructure.configurations;

import com.igor.reservation_system.applications.usecases.flight.GetAllFlightsUseCase;
import com.igor.reservation_system.applications.usecases.flight.GetFlightByIdUseCase;
import com.igor.reservation_system.applications.usecases.flight.GetFlightsByDestinationUseCase;
import com.igor.reservation_system.applications.usecases.flight.SaveFlightUseCase;
import com.igor.reservation_system.applications.usecases.flight.impl.GetAllFlightUseCaseImpl;
import com.igor.reservation_system.applications.usecases.flight.impl.GetFlightByIdUseCaseImpl;
import com.igor.reservation_system.applications.usecases.flight.impl.GetFlightsByDestinationUseCaseImpl;
import com.igor.reservation_system.applications.usecases.flight.impl.SaveFlightUseCaseImpl;
import com.igor.reservation_system.applications.usecases.user.GetAllUsersUseCase;
import com.igor.reservation_system.applications.usecases.user.GetUserByIdUseCase;
import com.igor.reservation_system.applications.usecases.user.SaveUserUseCase;
import com.igor.reservation_system.applications.usecases.user.impl.GetAllUsersUseCaseImpl;
import com.igor.reservation_system.applications.usecases.user.impl.GetUserByIdUseCaseImpl;
import com.igor.reservation_system.applications.usecases.user.impl.SaveUserUseCaseImpl;
import com.igor.reservation_system.core.gateways.FlightGateway;
import com.igor.reservation_system.core.gateways.UserGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    /* Flight Beans */
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

    /* User Beans */
    @Bean
    public SaveUserUseCase saveUserUseCase(UserGateway userGateway) {
        return new SaveUserUseCaseImpl(userGateway);
    }

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(UserGateway userGateway) {
        return new GetAllUsersUseCaseImpl(userGateway);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserGateway userGateway) {
        return new GetUserByIdUseCaseImpl(userGateway);
    }


}
