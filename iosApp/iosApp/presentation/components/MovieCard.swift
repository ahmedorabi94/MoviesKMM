//
//  MovieCard.swift
//  iosApp
//
//  Created by Ahmed Orabi on 22/12/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared
import SDWebImageSwiftUI

struct MovieCard: View {
    
    private let movie : Movie
    let imageUrl  = "https://image.tmdb.org/t/p/w500"
    
    init(movie : Movie) {
        self.movie = movie
    }
    
    
    var body: some View {
        
        VStack{
            WebImage(url: URL(string: "\(imageUrl)\(movie.backdrop_path)"))
                .resizable()
                .placeholder(Image(systemName: "photo"))
                .placeholder{Rectangle().foregroundColor(.white)}
                .indicator(.activity)
                .transition(.fade(duration: 0.5))
                .scaledToFit()
                .frame(height: 250, alignment: .center)
                .clipped()
            
            HStack(alignment: .lastTextBaseline){
                Text(movie.title)
                    .frame(alignment: .center)
                
                
                Spacer()
                Text(String(movie.vote_average))
                    .frame(alignment: .trailing)
                    

            }
            .padding(.top,4)
            .padding(.leading,4)
            .padding(.trailing,4)
            .padding(.bottom,8)
            
        }
        .background(Color.white)
        .cornerRadius(8)
        .shadow(radius: 5)
    
    }
}

