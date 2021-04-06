package com.example.guestbook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ServiceTest {

    @Mock
    GuestBookRepository mockGuestBookRepository;

    @InjectMocks
    VisitorService subject;
    @Test
    void createAMovieTest() {
        VisitorDto visitorDto = new VisitorDto("Rohit", "Good Comment");
        subject.create(visitorDto);
        verify(mockGuestBookRepository).save(
                new VisitorEntity("Rohit", "Good Comment"));
    }
    @Test
    public void getAllEntries(){
        //Setup
        when(mockGuestBookRepository.findAll()).thenReturn(
                Arrays.asList(
                        new VisitorEntity("Rohit", "Good Comment"),
                        new VisitorEntity("Ranjan", "bad comment"))
                );

        //Exercise
        List<VisitorDto> actual = subject.fetchAll();

        //Assert
        assertThat(actual.size()).isEqualTo(2);
    }
}
