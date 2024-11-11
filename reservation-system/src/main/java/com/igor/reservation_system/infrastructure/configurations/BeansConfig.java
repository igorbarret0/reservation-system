package com.igor.reservation_system.infrastructure.configurations;

import com.igor.reservation_system.applications.usecases.flight.GetAllFlightsUseCase;
import com.igor.reservation_system.applications.usecases.flight.GetFlightByIdUseCase;
import com.igor.reservation_system.applications.usecases.flight.GetFlightsByDestinationUseCase;
import com.igor.reservation_system.applications.usecases.flight.SaveFlightUseCase;
import com.igor.reservation_system.applications.usecases.flight.impl.GetAllFlightUseCaseImpl;
import com.igor.reservation_system.applications.usecases.flight.impl.GetFlightByIdUseCaseImpl;
import com.igor.reservation_system.applications.usecases.flight.impl.GetFlightsByDestinationUseCaseImpl;
import com.igor.reservation_system.applications.usecases.flight.impl.SaveFlightUseCaseImpl;
import com.igor.reservation_system.applications.usecases.flightReservation.MakeFlightReservationUseCase;
import com.igor.reservation_system.applications.usecases.flightReservation.impl.MakeFlightReservationUseCaseImpl;
import com.igor.reservation_system.applications.usecases.hotel.GetAllHotelsUseCase;
import com.igor.reservation_system.applications.usecases.hotel.GetHotelByIdUseCase;
import com.igor.reservation_system.applications.usecases.hotel.GetHotelsByLocationUseCase;
import com.igor.reservation_system.applications.usecases.hotel.SaveHotelUseCase;
import com.igor.reservation_system.applications.usecases.hotel.impl.GetAllHotelsUseCaseImpl;
import com.igor.reservation_system.applications.usecases.hotel.impl.GetHotelByIdUseCaseImpl;
import com.igor.reservation_system.applications.usecases.hotel.impl.GetHotelsByLocationUseCaseImpl;
import com.igor.reservation_system.applications.usecases.hotel.impl.SaveHotelUseCaseImpl;
import com.igor.reservation_system.applications.usecases.hotelReservation.MakeHotelReservationUseCase;
import com.igor.reservation_system.applications.usecases.hotelReservation.impl.MakeHotelReservationUseCaseImpl;
import com.igor.reservation_system.applications.usecases.payment.MakePaymentUseCase;
import com.igor.reservation_system.applications.usecases.payment.impl.MakePaymentUseCaseImpl;
import com.igor.reservation_system.applications.usecases.user.GetAllUsersUseCase;
import com.igor.reservation_system.applications.usecases.user.GetUserByIdUseCase;
import com.igor.reservation_system.applications.usecases.user.SaveUserUseCase;
import com.igor.reservation_system.applications.usecases.user.impl.GetAllUsersUseCaseImpl;
import com.igor.reservation_system.applications.usecases.user.impl.GetUserByIdUseCaseImpl;
import com.igor.reservation_system.applications.usecases.user.impl.SaveUserUseCaseImpl;
import com.igor.reservation_system.core.gateways.*;
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

    /* Flight Reservation Beans */

    @Bean
    public MakeFlightReservationUseCase makeFlightReservationUseCase(FlightReservationGateway flightReservationGateway,
                                                                     UserGateway userGateway,
                                                                     FlightGateway flightGateway) {

        return new MakeFlightReservationUseCaseImpl(flightReservationGateway, userGateway, flightGateway);
    }

    /* Payment Beans */

    @Bean
    public MakePaymentUseCase makePaymentUseCase(FlightReservationGateway flightReservationGateway,
                                                 FlightGateway flightGateway,
                                                 UserGateway userGateway, PaymentGateway paymentGateway, HotelReservationGateway hotelReservationGateway,
                                                 HotelGateway hotelGateway) {

        return new MakePaymentUseCaseImpl(flightReservationGateway, flightGateway, userGateway, paymentGateway, hotelReservationGateway, hotelGateway);
    }

    /* Hotel Beans */

    @Bean
    public SaveHotelUseCase saveHotelUseCase(HotelGateway hotelGateway) {
        return new SaveHotelUseCaseImpl(hotelGateway);
    }

    @Bean
    public GetAllHotelsUseCase getAllHotelsUseCase(HotelGateway hotelGateway) {
        return new GetAllHotelsUseCaseImpl(hotelGateway);
    }

    @Bean
    public GetHotelByIdUseCase getHotelByIdUseCase(HotelGateway hotelGateway) {
        return new GetHotelByIdUseCaseImpl(hotelGateway);
    }

    @Bean
    public GetHotelsByLocationUseCase getHotelsByLocationUseCase(HotelGateway hotelGateway) {
        return new GetHotelsByLocationUseCaseImpl(hotelGateway);
    }

    /* Hotel Reservation Beans */

    @Bean
    public MakeHotelReservationUseCase makeHotelReservationUseCase(HotelReservationGateway hotelReservationGateway, UserGateway userGateway,
                                                                   HotelGateway hotelGateway) {

        return new MakeHotelReservationUseCaseImpl(hotelReservationGateway, userGateway, hotelGateway);
    }

}
