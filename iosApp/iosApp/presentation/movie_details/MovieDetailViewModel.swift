//
//  MovieDetailViewModel.swift
//  iosApp
//
//  Created by Ahmed Orabi on 25/12/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

class MovieDetailViewModel : ObservableObject {
    
    let getMoviesDetailUseCase : GetMoviesDetailUseCase
    
    @Published var state : MovieDetailsState = MovieDetailsState()
    
    init(movieId: Int , getMovieUseCase : GetMoviesDetailUseCase) {
        self.getMoviesDetailUseCase = getMovieUseCase
     
        onTriggerEvents(stateEvent : MovieDetailsEvents.GETMovieDetails(movieId: Int32(movieId)))
    }
    
    func onTriggerEvents(stateEvent : MovieDetailsEvents){
        switch stateEvent {
        case is MovieDetailsEvents.GETMovieDetails:
            getMoviesDetails(movieId: Int((stateEvent as! MovieDetailsEvents.GETMovieDetails).movieId))
        default:
            doNoThing()
        }
    }
    
    func doNoThing(){
        
    }
    
    func getMoviesDetails(movieId : Int){
        let currentState = (self.state.copy() as! MovieDetailsState)
        
        do {
            try getMoviesDetailUseCase.execute(movieId: Int32(movieId)).collectCommon(coroutineScope: nil, callback: { dateState in
                if dateState != nil{
                    let isLoading = dateState?.isLoading  ?? false
                    
                    self.updateState(isLoading: isLoading)
                    
                    let data = dateState?.data
                    let message = dateState?.message
                    
                    if data != nil{
                      //  self.appendMovies(movies: data as! MovieResponse)
                        self.updateState(movie : data as! MovieDetailResponse)
                       // self.state = self.state.do
                    }
                    
                    if message != nil{
                        print(message)
                    }
        
                }
            })
        } catch  {
            print("\(error)")
        }
    }
    
    
    private func updateState(
         isLoading: Bool? = nil,
         page: Int? = nil,
         query: String? = nil,
         movie : MovieDetailResponse? = nil
     ){
         let currentState = (self.state.copy() as! MovieDetailsState)
         self.state = self.state.doCopy(
             isLoading: isLoading ?? currentState.isLoading,
             page: Int32(page ?? Int(currentState.page)),
             query: query ?? currentState.query,
             movie: movie ?? currentState.movie
            )
     }


    
}
