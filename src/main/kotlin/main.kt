import questions.*


fun main(args: Array<String>) {
//    Question_1_Two_Sum.runQuestion()
//    Question_2_Add_Two_Numbers.runQuestion()
//    Question_3_Longest_Substring_Without_Repeating_Characters.runQuestion()
//    Question_4_Median_of_Two_Sorted_Arrays.runQuestion()
//    Question_5_Longest_Palindromic_Substring.runQuestion()
//    Question_6_Zig_Zag_Conversion.runQuestion()
//    Question_8_String_to_Integer.runQuestion()
//    Question_9_Palindrome_Number.runQuestion()
//    Question_11_Container_With_Most_Water.runQuestion()
//    Question_12_Integer_to_Roman.runQuestion()
//    Question_13_Roman_to_Integer.runQuestion()
//    Question_14_Longest_Common_Prefix.runQuestion()
//    Question_15_3Sum.runQuestion()
//    Question_16_3Sum_Closest.runQuestion()
//    Question_17_Letter_Combinations_of_a_Phone_Number.runQuestion()
//    Question_19_Remove_Nth_Node_From_End_of_List.runQuestion()
//    Question_20_Valid_Parentheses.runQuestion()
//    Question_21_Merge_Two_Sorted_Lists.runQuestion()
//    Question_22_Generate_Parentheses.runQuestion()
//    Question_23_Merge_k_Sorted_Lists.runQuestion()
//    Question_26_Remove_Duplicates_from_Sorted_Array.runQuestion()
//    Question_27_Remove_Element.runQuestion()
//    Question_28_Find_the_Index_of_the_First_Occurrence_in_a_String.runQuestion()
//    Question_29_Divide_Two_Integers.runQuestion()
//    Question_33_Search_in_Rotated_Sorted_Array.runQuestion()
//    Question_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array.runQuestion()
//    Question_35_Search_Insert_Position.runQuestion()
//    Question_36_Valid_Sudoku.runQuestion()
//    Question_39_Combination_Sum.runQuestion()
//    Question_43_Multiply_Strings.runQuestion()
//    Question_45_Jump_Game_II.runQuestion()
//    Question_46_Permutations.runQuestion()
//    Question_48_Rotate_Image.runQuestion()
//    Question_49_Group_Anagrams.runQuestion()
//    Question_50_Pow.runQuestion()
//    Question_52_N_Queens_II.runQuestion()
//    Question_53_Maximum_Subarray.runQuestion()
//    Question_54_Spiral_Matrix.runQuestion()
//    Question_55_Jump_Game.runQuestion()
//    Question_56_Merge_Intervals.runQuestion()
//    Question_57_Insert_Interval.runQuestion()
//    Question_58_Length_of_Last_Word.runQuestion()
//    Question_61_Rotate_List.runQuestion()
//    Question_62_Unique_Paths.runQuestion()
//    Question_63_Unique_Paths_II.runQuestion()
//    Question_64_Minimum_Path_Sum.runQuestion()
//    Question_66_Plus_One.runQuestion()
//    Question_67_Add_Binary.runQuestion()
//    Question_69_Sqrtx.runQuestion()
//    Question_70_Climbing_Stairs.runQuestion()
//    Question_71_Simplify_Path.runQuestion()
//    Question_72_Edit_Distance.runQuestion()
//    Question_73_Set_Matrix_Zeroes.runQuestion()
//    Question_74_Search_a_2D_Matrix.runQuestion()
//    Question_75_Sort_Colors.runQuestion()
//    Question_77_Combinations.runQuestion()
//    Question_79_Word_Search.runQuestion()
//    Question_80_Remove_Duplicates_from_Sorted_Array_II.runQuestion()
//    Question_82_Remove_Duplicates_from_Sorted_List_II.runQuestion()
//    Question_86_Partition_List.runQuestion()
//    Question_88_Merge_Sorted_Array.runQuestion()
//    Question_92_Reverse_Linked_List_II.runQuestion()
//    Question_97_Interleaving_String.runQuestion()
//    Question_98_Validate_Binary_Search_Tree.runQuestion()
//    Question_100_Same_Tree.runQuestion()
//    Question_101_Symmetric_Tree.runQuestion()
//    Question_102_Binary_Tree_Level_Order_Traversal.runQuestion()
//    Question_103_Binary_Tree_Zigzag_Level_Order_Traversal.runQuestion()
//    Question_104_Maximum_Depth_of_Binary_Tree.runQuestion()
//    Question_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.runQuestion()
//    Question_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal.runQuestion()
//    Question_108_Convert_Sorted_Array_to_Binary_Search_Tree.runQuestion()
//    Question_112_Path_Sum.runQuestion()
//    Question_114_Flatten_Binary_Tree_to_Linked_List.runQuestion()
//    Question_117_Populating_Next_Right_Pointers_in_Each_Node_II.runQuestion()
//    Question_120_Triangle.runQuestion()
//    Question_121_Best_Time_to_Buy_and_Sell_Stock.runQuestion()
//    Question_122_Best_Time_to_Buy_and_Sell_Stock_II.runQuestion()
//    Question_123_Best_Time_to_Buy_and_Sell_Stock_III.runQuestion()
//    Question_125_Valid_Palindrome.runQuestion()
//    Question_128_Longest_Consecutive_Sequence.runQuestion()
//    Question_129_Sum_Root_to_Leaf_Numbers.runQuestion()
//    Question_130_Surrounded_Regions.runQuestion()
//    Question_133_Clone_Graph.runQuestion()
//    Question_134_Gas_Station.runQuestion()
//    Question_136_Single_Number.runQuestion()
//    Question_137_Single_Number_II.runQuestion()
//    Question_138_Copy_List_with_Random_Pointer.runQuestion()
//    Question_139_Word_Break.runQuestion()
//    Question_141_Linked_List_Cycle.runQuestion()
//    Question_148_Sort_List.runQuestion()
//    Question_149_Max_Points_on_a_Line.runQuestion()
//    Question_150_Evaluate_Reverse_Polish_Notation.runQuestion()
//    Question_151_Reverse_Words_in_a_String.runQuestion()
//    Question_153_Find_Minimum_in_Rotated_Sorted_Array.runQuestion()
//    Question_162_Find_Peak_Element.runQuestion()
//    Question_167_Two_Sum_II_Input_Array_Is_Sorted.runQuestion()
//    Question_169_Majority_Element.runQuestion()
//    Question_172_Factorial_Trailing_Zeroes.runQuestion()
//    Question_188_Best_Time_to_Buy_and_Sell_Stock_IV.runQuestion()
//    Question_189_Rotate_Array.runQuestion()
//    Question_190_Reverse_Bits.runQuestion()
//    Question_191_Number_of_1_Bits.runQuestion()
//    Question_198_House_Robber.runQuestion()
//    Question_199_Binary_Tree_Right_Side_View.runQuestion()
//    Question_200_Number_of_Islands.runQuestion()
//    Question_201_Bitwise_AND_of_Numbers_Range.runQuestion()
//    Question_202_Happy_Number.runQuestion()
//    Question_204_Count_Primes.runQuestion()
//    Question_205_Isomorphic_Strings.runQuestion()
//    Question_207_Course_Schedule.runQuestion()
//    Question_209_Minimum_Size_Subarray_Sum.runQuestion()
//    Question_210_Course_Schedule_II.runQuestion()
//    Question_212_Word_Search_II.runQuestion()
//    Question_215_Kth_Largest_Element_in_an_Array.runQuestion()
//    Question_219_Contains_Duplicate_II.runQuestion()
//    Question_221_Maximal_Square.runQuestion()
//    Question_222_Count_Complete_Tree_Nodes.runQuestion()
//    Question_226_Invert_Binary_Tree.runQuestion()
//    Question_228_Summary_Ranges.runQuestion()
//    Question_230_Kth_Smallest_Element_in_a_BST.runQuestion()
//    Question_236_Lowest_Common_Ancestor_of_a_Binary_Tree.runQuestion()
//    Question_238_Product_of_Array_Except_Self.runQuestion()
//    Question_242_Valid_Anagram.runQuestion()
//    Question_274_H_Index.runQuestion()
//    Question_283_Move_Zeroes.runQuestion()
//    Question_287_Find_the_Duplicate_Number.runQuestion()
//    Question_289_Game_of_Life.runQuestion()
//    Question_290_Word_Pattern.runQuestion()
//    Question_300_Longest_Increasing_Subsequence.runQuestion()
//    Question_322_Coin_Change.runQuestion()
//    Question_338_Counting_Bits.runQuestion()
//    Question_344_Reverse_String.runQuestion()
//    Question_354_Russian_Doll_Envelopes.runQuestion()
//    Question_373_Find_K_Pairs_with_Smallest_Sums.runQuestion()
//    Question_383_Ransom_Note.runQuestion()
//    Question_387_First_Unique_Character_in_a_String.runQuestion()
//    Question_392_Is_Subsequence.runQuestion()
//    Question_399_Evaluate_Division.runQuestion()
//    Question_433_Minimum_Genetic_Mutation.runQuestion()
//    Question_442_Find_All_Duplicates_in_an_Array.runQuestion()
//    Question_452_Minimum_Number_of_Arrows_to_Burst_Balloons.runQuestion()
//    Question_455_Assign_Cookies.runQuestion()
//    Question_496_Next_Greater_Element_I.runQuestion()
//    Question_518_Coin_Change_II.runQuestion()
//    Question_530_Minimum_Absolute_Difference_in_BST.runQuestion()
//    Question_560_Subarray_Sum_Equals_K.runQuestion()
//    Question_576_Out_of_Boundary_Paths.runQuestion()
//    Question_621_Task_Scheduler.runQuestion()
//    Question_637_Average_of_Levels_in_Binary_Tree.runQuestion()
//    Question_652_Find_Duplicate_Subtrees.runQuestion()
//    Question_701_Insert_into_a_Binary_Search_Tree.runQuestion()
//    Question_704_Binary_Search.runQuestion()
//    Question_781_Rabbits_in_Forest.runQuestion()
    Question_841_Keys_and_Rooms.runQuestion()
//    Question_870_Advantage_Shuffle.runQuestion()
//    Question_876_Middle_of_the_Linked_List.runQuestion()
//    Question_907_Sum_of_Subarray_Minimums.runQuestion()
//    Question_909_Snakes_and_Ladders.runQuestion()
//    Question_912_Sort_an_Array.runQuestion()
//    Question_918_Maximum_Sum_Circular_Subarray.runQuestion()
//    Question_948_Bag_of_Tokens.runQuestion()
//    Question_977_Squares_of_a_Sorted_Array.runQuestion()
//    Question_991_Broken_Calculator.runQuestion()
//    Question_993_Cousins_in_Binary_Tree.runQuestion()
//    Question_1041_Robot_Bounded_In_Circle.runQuestion()
//    Question_1046_Last_Stone_Weight.runQuestion()
//    Question_1047_Remove_All_Adjacent_Duplicates_In_String.runQuestion()
//    Question_1054_Distant_Barcodes.runQuestion()
//    Question_1024_Video_Stitching.runQuestion()
//    Question_1110_Delete_Nodes_And_Return_Forest.runQuestion()
//    Question_1143_Longest_Common_Subsequence.runQuestion()
//    Question_1144_Decrease_Elements_To_Make_Array_Zigzag.runQuestion()
//    Question_1170_Compare_Strings_by_Frequency_of_the_Smallest_Character.runQuestion()
//    Question_1248_Count_Number_of_Nice_Subarrays.runQuestion()
//    Question_1131_Maximum_of_Absolute_Value_Expression.runQuestion()
//    Question_1253_Reconstruct_a_2_Row_Binary_Matrix.runQuestion()
//    Question_1260_Shift_2D_Grid.runQuestion()
//    Question_1266_Minimum_Time_Visiting_All_Points.runQuestion()
//    Question_1301_Number_of_Paths_with_Max_Score.runQuestion()
//    Question_1315_Sum_of_Nodes_with_Even_Valued_Grandparent.runQuestion()
//    Question_1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c.runQuestion()
//    Question_1346_Check_If_N_and_Its_Double_Exist.runQuestion()
//    Question_1351_Count_Negative_Numbers_in_a_Sorted_Matrix.runQuestion()
//    Question_1405_Longest_Happy_String.runQuestion()
//    Question_1475_Final_Prices_With_a_Special_Discount_in_a_Shop.runQuestion()
//    Question_1544_Make_The_String_Great.runQuestion()
//    Question_1577_Number_of_Ways_Where_Square_of_Number_Is_Equal_to_Product_of_Two_Numbers.runQuestion()
//    Question_1662_Check_If_Two_String_Arrays_are_Equivalent.runQuestion()
//    Question_1688_Count_of_Matches_in_Tournament.runQuestion()
//    Question_1705_Maximum_Number_of_Eaten_Apples.runQuestion()
//    Question_1727_Largest_Submatrix_With_Rearrangements.runQuestion()
//    Question_1736_Latest_Time_by_Replacing_Hidden_Digits.runQuestion()
//    Question_1752_Check_if_Array_Is_Sorted_and_Rotated.runQuestion()
//    Question_1758_Minimum_Changes_To_Make_Alternating_Binary_String.runQuestion()
//    Question_1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box.runQuestion()
//    Question_1814_Count_Nice_Pairs_in_an_Array.runQuestion()
//    Question_1877_Minimize_Maximum_Pair_Sum_in_Array.runQuestion()
//    Question_1882_Process_Tasks_Using_Servers.runQuestion()
//    Question_1884_Egg_Drop_With_2_Eggs_and_N_Floors.runQuestion()
//    Question_1929_Concatenation_of_Array.runQuestion()
//    Question_1936_Add_Minimum_Number_of_Rungs.runQuestion()
//    Question_2032_Two_Out_of_Three.runQuestion()
//    Question_2057_Smallest_Index_With_Equal_Value.runQuestion()
//    Question_2126_Destroying_Asteroids.runQuestion()
//    Question_2185_Counting_Words_With_a_Given_Prefix.runQuestion()
//    Question_2191_Sort_the_Jumbled_Numbers.runQuestion()
//    Question_2209_Minimum_White_Tiles_After_Covering_With_Carpets.runQuestion()
//    Question_2216_Minimum_Deletions_to_Make_Array_Beautiful.runQuestion()
//    Question_2335_Minimum_Amount_of_Time_to_Fill_Cups.runQuestion()
//    Question_2337_Move_Pieces_to_Obtain_a_String.runQuestion()
//    Question_2357_Make_Array_Zero_by_Subtracting_Equal_Amounts.runQuestion()
//    Question_2381_Shifting_Letters_II.runQuestion()
//    Question_2395_Find_Subarrays_With_Equal_Sum.runQuestion()
//    Question_2449_Minimum_Number_of_Operations_to_Make_Arrays_Similar.runQuestion()
//    Question_2460_Apply_Operations_to_an_Array.runQuestion()
//    Question_2488_Count_Subarrays_With_Median_K.runQuestion()
//    Question_2500_Delete_Greatest_Value_in_Each_Row.runQuestion()
//    Question_2517_Maximum_Tastiness_of_Candy_Basket.runQuestion()
//    Question_2522_Partition_String_Into_Substrings_With_Values_at_Most_K.runQuestion()
//    Question_2525_Categorize_Box_According_to_Criteria.runQuestion()
//    Question_2555_Maximize_Win_From_Two_Segments.runQuestion()
//    Question_2571_Minimum_Operations_to_Reduce_an_Integer_to_0.runQuestion()
//    Question_2607_Make_K_Subarray_Sums_Equal.runQuestion()
//    Question_2611_Mice_and_Cheese.runQuestion()
//    Question_2643_Row_With_Maximum_Ones.runQuestion()
//    Question_2679_Sum_in_a_Matrix.runQuestion()
//    Question_2684_Maximum_Number_of_Moves_in_a_Grid.runQuestion()
//    Question_2685_Count_the_Number_of_Complete_Components.runQuestion()
//    Question_2593_Find_Score_of_an_Array_After_Marking_All_Elements.runQuestion()
//    Question_2639_Find_the_Width_of_Columns_of_a_Grid.runQuestion()
//    Question_2733_Neither_Minimum_nor_Maximum.runQuestion()
//    Question_2766_Relocate_Marbles.runQuestion()
}