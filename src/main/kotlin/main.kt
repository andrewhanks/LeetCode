import questions.*

fun main(args: Array<String>) {
//    Question_1_Two_Sum.runQuestion()
//    Question_2_Add_Two_Numbers.runQuestion()
//    Question_3_Longest_Substring_Without_Repeating_Characters.runQuestion()
//    Question_4_Median_of_Two_Sorted_Arrays.runQuestion()
//    Question_5_Longest_Palindromic_Substring.runQuestion()
//    Question_6_Zig_Zag_Conversion.runQuestion()
//    Question_7_Reverse_Integer.runQuestion()
//    Question_8_String_to_Integer.runQuestion()
//    Question_9_Palindrome_Number.runQuestion()
//    Question_11_Container_With_Most_Water.runQuestion()
//    Question_12_Integer_to_Roman.runQuestion()
//    Question_13_Roman_to_Integer.runQuestion()
//    Question_14_Longest_Common_Prefix.runQuestion()
//    Question_15_3Sum.runQuestion()
//    Question_16_3Sum_Closest.runQuestion()
//    Question_17_Letter_Combinations_of_a_Phone_Number.runQuestion()
//    Question_18_4Sum.runQuestion()
//    Question_19_Remove_Nth_Node_From_End_of_List.runQuestion()
//    Question_20_Valid_Parentheses.runQuestion()
//    Question_21_Merge_Two_Sorted_Lists.runQuestion()
//    Question_22_Generate_Parentheses.runQuestion()
//    Question_23_Merge_k_Sorted_Lists.runQuestion()
//    Question_24_Swap_Nodes_in_Pairs.runQuestion()
//    Question_26_Remove_Duplicates_from_Sorted_Array.runQuestion()
//    Question_27_Remove_Element.runQuestion()
//    Question_28_Find_the_Index_of_the_First_Occurrence_in_a_String.runQuestion()
//    Question_29_Divide_Two_Integers.runQuestion()
//    Question_31_Next_Permutation.runQuestion()
//    Question_33_Search_in_Rotated_Sorted_Array.runQuestion()
//    Question_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array.runQuestion()
//    Question_35_Search_Insert_Position.runQuestion()
//    Question_36_Valid_Sudoku.runQuestion()
//    Question_39_Combination_Sum.runQuestion()
//    Question_40_Combination_Sum_II.runQuestion()
//    Question_42_Trapping_Rain_Water.runQuestion()
//    Question_43_Multiply_Strings.runQuestion()
//    Question_45_Jump_Game_II.runQuestion()
//    Question_46_Permutations.runQuestion()
//    Question_47_Permutations_II.runQuestion()
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
//    Question_59_Spiral_Matrix_II.runQuestion()
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
//    Question_76_Minimum_Window_Substring.runQuestion()
//    Question_77_Combinations.runQuestion()
//    Question_78_Subsets.runQuestion()
//    Question_79_Word_Search.runQuestion()
//    Question_80_Remove_Duplicates_from_Sorted_Array_II.runQuestion()
//    Question_82_Remove_Duplicates_from_Sorted_List_II.runQuestion()
//    Question_84_Largest_Rectangle_in_Histogram.runQuestion()
//    Question_86_Partition_List.runQuestion()
//    Question_88_Merge_Sorted_Array.runQuestion()
//    Question_90_Subsets_II.runQuestion()
//    Question_91_Decode_Ways.runQuestion()
//    Question_92_Reverse_Linked_List_II.runQuestion()
//    Question_93_Restore_IP_Addresses.runQuestion()
//    Question_96_Unique_Binary_Search_Trees.runQuestion()
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
//    Question_110_Balanced_Binary_Tree.runQuestion()
//    Question_111_Minimum_Depth_of_Binary_Tree.runQuestion()
//    Question_112_Path_Sum.runQuestion()
//    Question_113_Path_Sum_II.runQuestion()
//    Question_114_Flatten_Binary_Tree_to_Linked_List.runQuestion()
//    Question_115_Distinct_Subsequences.runQuestion()
//    Question_116_Populating_Next_Right_Pointers_in_Each_Node.runQuestion()
//    Question_117_Populating_Next_Right_Pointers_in_Each_Node_II.runQuestion()
//    Question_120_Triangle.runQuestion()
//    Question_121_Best_Time_to_Buy_and_Sell_Stock.runQuestion()
//    Question_122_Best_Time_to_Buy_and_Sell_Stock_II.runQuestion()
//    Question_123_Best_Time_to_Buy_and_Sell_Stock_III.runQuestion()
//    Question_125_Valid_Palindrome.runQuestion()
//    Question_127_Word_Ladder.runQuestion()
//    Question_128_Longest_Consecutive_Sequence.runQuestion()
//    Question_129_Sum_Root_to_Leaf_Numbers.runQuestion()
//    Question_130_Surrounded_Regions.runQuestion()
//    Question_131_Palindrome_Partitioning.runQuestion()
//    Question_132_Palindrome_Partitioning_II.runQuestion()
//    Question_133_Clone_Graph.runQuestion()
//    Question_134_Gas_Station.runQuestion()
//    Question_136_Single_Number.runQuestion()
//    Question_137_Single_Number_II.runQuestion()
//    Question_138_Copy_List_with_Random_Pointer.runQuestion()
//    Question_139_Word_Break.runQuestion()
//    Question_141_Linked_List_Cycle.runQuestion()
//    Question_142_Linked_List_Cycle_II.runQuestion()
//    Question_143_Reorder_List.runQuestion()
//    Question_148_Sort_List.runQuestion()
//    Question_149_Max_Points_on_a_Line.runQuestion()
//    Question_150_Evaluate_Reverse_Polish_Notation.runQuestion()
//    Question_151_Reverse_Words_in_a_String.runQuestion()
//    Question_152_Maximum_Product_Subarray.runQuestion()
//    Question_153_Find_Minimum_in_Rotated_Sorted_Array.runQuestion()
//    Question_160_Intersection_of_Two_Linked_Lists.runQuestion()
//    Question_162_Find_Peak_Element.runQuestion()
//    Question_167_Two_Sum_II_Input_Array_Is_Sorted.runQuestion()
//    Question_169_Majority_Element.runQuestion()
//    Question_172_Factorial_Trailing_Zeroes.runQuestion()
//    Question_174_Dungeon_Game.runQuestion()
//    Question_179_Largest_Number.runQuestion()
//    Question_188_Best_Time_to_Buy_and_Sell_Stock_IV.runQuestion()
//    Question_189_Rotate_Array.runQuestion()
//    Question_190_Reverse_Bits.runQuestion()
//    Question_191_Number_of_1_Bits.runQuestion()
//    Question_198_House_Robber.runQuestion()
//    Question_199_Binary_Tree_Right_Side_View.runQuestion()
//    Question_200_Number_of_Islands.runQuestion()
//    Question_201_Bitwise_AND_of_Numbers_Range.runQuestion()
//    Question_202_Happy_Number.runQuestion()
//    Question_203_Remove_Linked_List_Elements.runQuestion()
//    Question_204_Count_Primes.runQuestion()
//    Question_205_Isomorphic_Strings.runQuestion()
//    Question_206_Reverse_Linked_List.runQuestion()
//    Question_207_Course_Schedule.runQuestion()
//    Question_209_Minimum_Size_Subarray_Sum.runQuestion()
//    Question_210_Course_Schedule_II.runQuestion()
//    Question_212_Word_Search_II.runQuestion()
//    Question_213_House_Robber_II.runQuestion()
//    Question_215_Kth_Largest_Element_in_an_Array.runQuestion()
//    Question_216_Combination_Sum_III.runQuestion()
//    Question_219_Contains_Duplicate_II.runQuestion()
//    Question_221_Maximal_Square.runQuestion()
//    Question_222_Count_Complete_Tree_Nodes.runQuestion()
//    Question_226_Invert_Binary_Tree.runQuestion()
//    Question_227_Basic_Calculator_II.runQuestion()
//    Question_228_Summary_Ranges.runQuestion()
//    Question_230_Kth_Smallest_Element_in_a_BST.runQuestion()
//    Question_234_Palindrome_Linked_List.runQuestion()
//    Question_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree.runQuestion()
//    Question_236_Lowest_Common_Ancestor_of_a_Binary_Tree.runQuestion()
//    Question_238_Product_of_Array_Except_Self.runQuestion()
//    Question_239_Sliding_Window_Maximum.runQuestion()
//    Question_242_Valid_Anagram.runQuestion()
//    Question_257_Binary_Tree_Paths.runQuestion()
//    Question_274_H_Index.runQuestion()
//    Question_278_First_Bad_Version.runQuestion()
//    Question_279_Perfect_Squares.runQuestion()
//    Question_283_Move_Zeroes.runQuestion()
//    Question_287_Find_the_Duplicate_Number.runQuestion()
//    Question_289_Game_of_Life.runQuestion()
//    Question_290_Word_Pattern.runQuestion()
//    Question_300_Longest_Increasing_Subsequence.runQuestion()
//    Question_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown.runQuestion()
//    Question_310_Minimum_Height_Trees.runQuestion()
//    Question_322_Coin_Change.runQuestion()
//    Question_328_Odd_Even_Linked_List.runQuestion()
//    Question_337_House_Robber_III.runQuestion()
//    Question_338_Counting_Bits.runQuestion()
//    Question_343_Integer_Break.runQuestion()
//    Question_344_Reverse_String.runQuestion()
//    Question_349_Intersection_of_Two_Arrays.runQuestion()
//    Question_347_Top_K_Frequent_Elements.runQuestion()
//    Question_354_Russian_Doll_Envelopes.runQuestion()
//    Question_373_Find_K_Pairs_with_Smallest_Sums.runQuestion()
//    Question_375_Guess_Number_Higher_or_Lower_II.runQuestion()
//    Question_376_Wiggle_Subsequence.runQuestion()
//    Question_377_Combination_Sum_IV.runQuestion()
//    Question_383_Ransom_Note.runQuestion()
//    Question_387_First_Unique_Character_in_a_String.runQuestion()
//    Question_392_Is_Subsequence.runQuestion()
//    Question_394_Decode_String.runQuestion()
//    Question_399_Evaluate_Division.runQuestion()
//    Question_404_Sum_of_Left_Leaves.runQuestion()
//    Question_406_Queue_Reconstruction_by_Height.runQuestion()
//    Question_416_Partition_Equal_Subset_Sum.runQuestion()
//    Question_417_Pacific_Atlantic_Water_Flow.runQuestion()
//    Question_421_Maximum_XOR_of_Two_Numbers_in_an_Array.runQuestion()
//    Question_424_Longest_Repeating_Character_Replacement.runQuestion()
//    Question_433_Minimum_Genetic_Mutation.runQuestion()
//    Question_435_Non_overlapping_Intervals.runQuestion()
//    Question_437_Path_Sum_III.runQuestion()
//    Question_438_Find_All_Anagrams_in_a_String.runQuestion()
//    Question_442_Find_All_Duplicates_in_an_Array.runQuestion()
//    Question_450_Delete_Node_in_a_BST.runQuestion()
//    Question_452_Minimum_Number_of_Arrows_to_Burst_Balloons.runQuestion()
//    Question_454_4Sum_II.runQuestion()
//    Question_455_Assign_Cookies.runQuestion()
//    Question_459_Repeated_Substring_Pattern.runQuestion()
//    Question_463_Island_Perimeter.runQuestion()
//    Question_474_Ones_and_Zeroes.runQuestion()
//    Question_491_Non_decreasing_Subsequences.runQuestion()
//    Question_494_Target_Sum.runQuestion()
//    Question_496_Next_Greater_Element_I.runQuestion()
//    Question_503_Next_Greater_Element_II.runQuestion()
//    Question_509_Fibonacci_Number.runQuestion()
//    Question_513_Find_Bottom_Left_Tree_Value.runQuestion()
//    Question_516_Longest_Palindromic_Subsequence.runQuestion()
//    Question_518_Coin_Change_II.runQuestion()
//    Question_525_Contiguous_Array.runQuestion()
//    Question_530_Minimum_Absolute_Difference_in_BST.runQuestion()
//    Question_538_Convert_BST_to_Greater_Tree.runQuestion()
//    Question_541_Reverse_String_II.runQuestion()
//    Question_542_01_Matrix.runQuestion()
//    Question_547_Number_of_Provinces.runQuestion()
//    Question_560_Subarray_Sum_Equals_K.runQuestion()
//    Question_576_Out_of_Boundary_Paths.runQuestion()
//    Question_583_Delete_Operation_for_Two_Strings.runQuestion()
//    Question_617_Merge_Two_Binary_Trees.runQuestion()
//    Question_621_Task_Scheduler.runQuestion()
//    Question_637_Average_of_Levels_in_Binary_Tree.runQuestion()
//    Question_647_Palindromic_Substrings.runQuestion()
//    Question_649_Dota2_Senate.runQuestion()
//    Question_650_2_Keys_Keyboard.runQuestion()
//    Question_652_Find_Duplicate_Subtrees.runQuestion()
//    Question_654_Maximum_Binary_Tree.runQuestion()
//    Question_657_Robot_Return_to_Origin.runQuestion()
//    Question_658_Find_K_Closest_Elements.runQuestion()
//    Question_662_Maximum_Width_of_Binary_Tree.runQuestion()
//    Question_669_Trim_a_Binary_Search_Tree.runQuestion()
//    Question_673_Number_of_Longest_Increasing_Subsequence.runQuestion()
//    Question_674_Longest_Continuous_Increasing_Subsequence.runQuestion()
//    Question_684_Redundant_Connection.runQuestion()
//    Question_688_Knight_Probability_in_Chessboard.runQuestion()
//    Question_692_Top_K_Frequent_Words.runQuestion()
//    Question_695_Max_Area_of_Island.runQuestion()
//    Question_700_Search_in_a_Binary_Search_Tree.runQuestion()
//    Question_701_Insert_into_a_Binary_Search_Tree.runQuestion()
//    Question_704_Binary_Search.runQuestion()
//    Question_712_Minimum_ASCII_Delete_Sum_for_Two_Strings.runQuestion()
//    Question_714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee.runQuestion()
//    Question_718_Maximum_Length_of_Repeated_Subarray.runQuestion()
//    Question_721_Accounts_Merge.runQuestion()
//    Question_724_Find_Pivot_Index.runQuestion()
//    Question_735_Asteroid_Collision.runQuestion()
//    Question_738_Monotone_Increasing_Digits.runQuestion()
//    Question_739_Daily_Temperatures.runQuestion()
//    Question_743_Network_Delay_Time.runQuestion()
//    Question_746_Min_Cost_Climbing_Stairs.runQuestion()
//    Question_763_Partition_Labels.runQuestion()
//    Question_767_Reorganize_String.runQuestion()
//    Question_777_Swap_Adjacent_in_LR_String.runQuestion()
//    Question_781_Rabbits_in_Forest.runQuestion()
//    Question_785_Is_Graph_Bipartite.runQuestion()
//    Question_787_Cheapest_Flights_Within_K_Stops.runQuestion()
//    Question_789_Escape_The_Ghosts.runQuestion()
//    Question_790_Domino_and_Tromino_Tiling.runQuestion()
//    Question_792_Number_of_Matching_Subsequences.runQuestion()
//    Question_797_All_Paths_From_Source_to_Target.runQuestion()
//    Question_809_Expressive_Words.runQuestion()
//    Question_816_Ambiguous_Coordinates.runQuestion()
//    Question_820_Short_Encoding_of_Words.runQuestion()
//    Question_825_Friends_Of_Appropriate_Ages.runQuestion()
//    Question_826_Most_Profit_Assigning_Work.runQuestion()
//    Question_829_Consecutive_Numbers_Sum.runQuestion()
//    Question_838_Push_Dominoes.runQuestion()
//    Question_841_Keys_and_Rooms.runQuestion()
//    Question_844_Backspace_String_Compare.runQuestion()
//    Question_853_Car_Fleet.runQuestion()
//    Question_860_Lemonade_Change.runQuestion()
//    Question_863_All_Nodes_Distance_K_in_Binary_Tree.runQuestion()
//    Question_870_Advantage_Shuffle.runQuestion()
//    Question_875_Koko_Eating_Bananas.runQuestion()
//    Question_876_Middle_of_the_Linked_List.runQuestion()
//    Question_885_Spiral_Matrix_III.runQuestion()
//    Question_907_Sum_of_Subarray_Minimums.runQuestion()
//    Question_909_Snakes_and_Ladders.runQuestion()
//    Question_912_Sort_an_Array.runQuestion()
//    Question_915_Partition_Array_into_Disjoint_Intervals.runQuestion()
//    Question_916_Word_Subsets.runQuestion()
//    Question_918_Maximum_Sum_Circular_Subarray.runQuestion()
//    Question_922_Sort_Array_By_Parity_II.runQuestion()
//    Question_923_3Sum_With_Multiplicity.runQuestion()
//    Question_925_Long_Pressed_Name.runQuestion()
//    Question_926_Flip_String_to_Monotone_Increasing.runQuestion()
//    Question_931_Minimum_Falling_Path_Sum.runQuestion()
//    Question_935_Knight_Dialer.runQuestion()
//    Question_941_Valid_Mountain_Array.runQuestion()
//    Question_948_Bag_of_Tokens.runQuestion()
//    Question_950_Reveal_Cards_In_Increasing_Order.runQuestion()
//    Question_958_Check_Completeness_of_a_Binary_Tree.runQuestion()
//    Question_962_Maximum_Width_Ramp.runQuestion()
//    Question_973_K_Closest_Points_to_Origin.runQuestion()
//    Question_974_Subarray_Sums_Divisible_by_K.runQuestion()
//    Question_977_Squares_of_a_Sorted_Array.runQuestion()
//    Question_979_Distribute_Coins_in_Binary_Tree.runQuestion()
//    Question_983_Minimum_Cost_For_Tickets.runQuestion()
//    Question_987_Vertical_Order_Traversal_of_a_Binary_Tree.runQuestion()
//    Question_990_Satisfiability_of_Equality_Equations.runQuestion()
//    Question_991_Broken_Calculator.runQuestion()
//    Question_993_Cousins_in_Binary_Tree.runQuestion()
//    Question_994_Rotting_Oranges.runQuestion()
//    Question_1002_Find_Common_Characters.runQuestion()
//    Question_1004_Max_Consecutive_Ones_III.runQuestion()
//    Question_1005_Maximize_Sum_Of_Array_After_K_Negations.runQuestion()
//    Question_1011_Capacity_To_Ship_Packages_Within_D_Days.runQuestion()
//    Question_1017_Convert_to_Base_Neg_2.runQuestion()
//    Question_1020_Number_of_Enclaves.runQuestion()
//    Question_1024_Video_Stitching.runQuestion()
//    Question_1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays.runQuestion()
//    Question_1035_Uncrossed_Lines.runQuestion()
//    Question_1041_Robot_Bounded_In_Circle.runQuestion()
//    Question_1042_Flower_Planting_With_No_Adjacent.runQuestion()
//    Question_1046_Last_Stone_Weight.runQuestion()
//    Question_1047_Remove_All_Adjacent_Duplicates_In_String.runQuestion()
//    Question_1049_Last_Stone_Weight_II.runQuestion()
//    Question_1053_Previous_Permutation_With_One_Swap.runQuestion()
//    Question_1054_Distant_Barcodes.runQuestion()
//    Question_1091_Shortest_Path_in_Binary_Matrix.runQuestion()
//    Question_1108_Defanging_an_IP_Address.runQuestion()
//    Question_1110_Delete_Nodes_And_Return_Forest.runQuestion()
//    Question_1123_Lowest_Common_Ancestor_of_Deepest_Leaves.runQuestion()
//    Question_1130_Minimum_Cost_Tree_From_Leaf_Values.runQuestion()
//    Question_1131_Maximum_of_Absolute_Value_Expression.runQuestion()
//    Question_1143_Longest_Common_Subsequence.runQuestion()
//    Question_1144_Decrease_Elements_To_Make_Array_Zigzag.runQuestion()
//    Question_1155_Number_of_Dice_Rolls_With_Target_Sum.runQuestion()
//    Question_1162_As_Far_from_Land_as_Possible.runQuestion()
//    Question_1169_Invalid_Transactions.runQuestion()
//    Question_1170_Compare_Strings_by_Frequency_of_the_Smallest_Character.runQuestion()
//    Question_1201_Ugly_Number_III.runQuestion()
//    Question_1207_Unique_Number_of_Occurrences.runQuestion()
//    Question_1219_Path_with_Maximum_Gold.runQuestion()
//    Question_1221_Split_a_String_in_Balanced_Strings.runQuestion()
//    Question_1248_Count_Number_of_Nice_Subarrays.runQuestion()
//    Question_1249_Minimum_Remove_to_Make_Valid_Parentheses.runQuestion()
//    Question_1253_Reconstruct_a_2_Row_Binary_Matrix.runQuestion()
//    Question_1254_Number_of_Closed_Islands.runQuestion()
//    Question_1260_Shift_2D_Grid.runQuestion()
//    Question_1266_Minimum_Time_Visiting_All_Points.runQuestion()
//    Question_1277_Count_Square_Submatrices_with_All_Ones.runQuestion()
//    Question_1283_Find_the_Smallest_Divisor_Given_a_Threshold.runQuestion()
//    Question_1289_Minimum_Falling_Path_Sum_II.runQuestion()
//    Question_1300_Sum_of_Mutated_Array_Closest_to_Target.runQuestion()
//    Question_1301_Number_of_Paths_with_Max_Score.runQuestion()
//    Question_1311_Get_Watched_Videos_by_Your_Friends.runQuestion()
//    Question_1315_Sum_of_Nodes_with_Even_Valued_Grandparent.runQuestion()
//    Question_1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c.runQuestion()
//    Question_1319_Number_of_Operations_to_Make_Network_Connected.runQuestion()
//    Question_1332_Remove_Palindromic_Subsequences.runQuestion()
//    Question_1339_Maximum_Product_of_Splitted_Binary_Tree.runQuestion()
//    Question_1346_Check_If_N_and_Its_Double_Exist.runQuestion()
//    Question_1351_Count_Negative_Numbers_in_a_Sorted_Matrix.runQuestion()
//    Question_1356_Sort_Integers_by_The_Number_of_1_Bits.runQuestion()
//    Question_1358_Number_of_Substrings_Containing_All_Three_Characters.runQuestion()
//    Question_1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number.runQuestion()
//    Question_1366_Rank_Teams_by_Votes.runQuestion()
//    Question_1367_Linked_List_in_Binary_Tree.runQuestion()
//    Question_1372_Longest_ZigZag_Path_in_a_Binary_Tree.runQuestion()
//    Question_1382_Balance_a_Binary_Search_Tree.runQuestion()
//    Question_1386_Cinema_Seat_Allocation.runQuestion()
//    Question_1401_Circle_and_Rectangle_Overlapping.runQuestion()
//    Question_1402_Reducing_Dishes.runQuestion()
//    Question_1405_Longest_Happy_String.runQuestion()
//    Question_1419_Minimum_Number_of_Frogs_Croaking.runQuestion()
//    Question_1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit.runQuestion()
//    Question_1443_Minimum_Time_to_Collect_All_Apples_in_a_Tree.runQuestion()
//    Question_1462_Course_Schedule_IV.runQuestion()
//    Question_1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero.runQuestion()
//    Question_1475_Final_Prices_With_a_Special_Discount_in_a_Shop.runQuestion()
//    Question_1482_Minimum_Number_of_Days_to_Make_m_Bouquets.runQuestion()
//    Question_1487_Making_File_Names_Unique.runQuestion()
//    Question_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank.runQuestion()
//    Question_1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves.runQuestion()
//    Question_1524_Number_of_Sub_arrays_With_Odd_Sum.runQuestion()
//    Question_1540_Can_Convert_String_in_K_Moves.runQuestion()
//    Question_1544_Make_The_String_Great.runQuestion()
//    Question_1558_Minimum_Numbers_of_Function_Calls_to_Make_Target_Array.runQuestion()
//    Question_1567_Maximum_Length_of_Subarray_With_Positive_Product.runQuestion()
//    Question_1577_Number_of_Ways_Where_Square_of_Number_Is_Equal_to_Product_of_Two_Numbers.runQuestion()
//    Question_1583_Count_Unhappy_Friends.runQuestion()
//    Question_1604_Alert_Using_Same_Key_Card_Three_or_More_Times_in_a_One_Hour_Period.runQuestion()
//    Question_1620_Coordinate_With_Maximum_Network_Quality.runQuestion()
//    Question_1662_Check_If_Two_String_Arrays_are_Equivalent.runQuestion()
//    Question_1680_Concatenation_of_Consecutive_Binary_Numbers.runQuestion()
//    Question_1688_Count_of_Matches_in_Tournament.runQuestion()
//    Question_1705_Maximum_Number_of_Eaten_Apples.runQuestion()
//    Question_1727_Largest_Submatrix_With_Rearrangements.runQuestion()
//    Question_1736_Latest_Time_by_Replacing_Hidden_Digits.runQuestion()
//    Question_1738_Find_Kth_Largest_XOR_Coordinate_Value.runQuestion()
//    Question_1752_Check_if_Array_Is_Sorted_and_Rotated.runQuestion()
//    Question_1758_Minimum_Changes_To_Make_Alternating_Binary_String.runQuestion()
//    Question_1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box.runQuestion()
//    Question_1774_Closest_Dessert_Cost.runQuestion()
    Question_1781_Sum_of_Beauty_of_All_Substrings.runQuestion()
//    Question_1801_Number_of_Orders_in_the_Backlog.runQuestion()
//    Question_1814_Count_Nice_Pairs_in_an_Array.runQuestion()
//    Question_1864_Minimum_Number_of_Swaps_to_Make_the_Binary_String_Alternating.runQuestion()
//    Question_1870_Minimum_Speed_to_Arrive_on_Time.runQuestion()
//    Question_1877_Minimize_Maximum_Pair_Sum_in_Array.runQuestion()
//    Question_1882_Process_Tasks_Using_Servers.runQuestion()
//    Question_1884_Egg_Drop_With_2_Eggs_and_N_Floors.runQuestion()
//    Question_1899_Merge_Triplets_to_Form_Target_Triplet.runQuestion()
//    Question_1905_Count_Sub_Islands.runQuestion()
//    Question_1922_Count_Good_Numbers.runQuestion()
//    Question_1926_Nearest_Exit_from_Entrance_in_Maze.runQuestion()
//    Question_1929_Concatenation_of_Array.runQuestion()
//    Question_1936_Add_Minimum_Number_of_Rungs.runQuestion()
//    Question_1942_The_Number_of_the_Smallest_Unoccupied_Chair.runQuestion()
//    Question_1947_Maximum_Compatibility_Score_Sum.runQuestion()
//    Question_1958_Check_if_Move_is_Legal.runQuestion()
//    Question_1963_Minimum_Number_of_Swaps_to_Make_the_String_Balanced.runQuestion()
//    Question_1971_Find_if_Path_Exists_in_Graph.runQuestion()
//    Question_1975_Maximum_Matrix_Sum.runQuestion()
//    Question_2024_Maximize_the_Confusion_of_an_Exam.runQuestion()
//    Question_2032_Two_Out_of_Three.runQuestion()
//    Question_2033_Minimum_Operations_to_Make_a_Uni_Value_Grid.runQuestion()
//    Question_2057_Smallest_Index_With_Equal_Value.runQuestion()
//    Question_2063_Vowels_of_All_Substrings.runQuestion()
//    Question_2074_Reverse_Nodes_in_Even_Length_Groups.runQuestion()
//    Question_2086_Minimum_Number_of_Food_Buckets_to_Feed_the_Hamsters.runQuestion()
//    Question_2100_Find_Good_Days_to_Rob_the_Bank.runQuestion()
//    Question_2115_Find_All_Possible_Recipes_from_Given_Supplies.runQuestion()
//    Question_2126_Destroying_Asteroids.runQuestion()
//    Question_2140_Solving_Questions_With_Brainpower.runQuestion()
//    Question_2145_Count_the_Hidden_Sequences.runQuestion()
//    Question_2170_Minimum_Operations_to_Make_the_Array_Alternating.runQuestion()
//    Question_2182_Construct_String_With_Repeat_Limit.runQuestion()
//    Question_2185_Counting_Words_With_a_Given_Prefix.runQuestion()
//    Question_2187_Minimum_Time_to_Complete_Trips.runQuestion()
//    Question_2191_Sort_the_Jumbled_Numbers.runQuestion()
//    Question_2195_Append_K_Integers_With_Minimal_Sum.runQuestion()
//    Question_2196_Create_Binary_Tree_From_Descriptions.runQuestion()
//    Question_2209_Minimum_White_Tiles_After_Covering_With_Carpets.runQuestion()
//    Question_2216_Minimum_Deletions_to_Make_Array_Beautiful.runQuestion()
//    Question_2222_Number_of_Ways_to_Select_Buildings.runQuestion()
//    Question_2226_Maximum_Candies_Allocated_to_K_Children.runQuestion()
//    Question_2232_Minimize_Result_by_Adding_Parentheses_to_Expression.runQuestion()
//    Question_2233_Maximum_Product_After_K_Increments.runQuestion()
//    Question_2235_Add_Two_Integers.runQuestion()
//    Question_2249_Count_Lattice_Points_Inside_a_Circle.runQuestion()
//    Question_2257_Count_Unguarded_Cells_in_the_Grid.runQuestion()
//    Question_2275_Largest_Combination_With_Bitwise_AND_Greater_Than_Zero.runQuestion()
//    Question_2280_Minimum_Lines_to_Represent_a_Line_Chart.runQuestion()
//    Question_2304_Minimum_Path_Cost_in_a_Grid.runQuestion()
//    Question_2316_Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph.runQuestion()
//    Question_2317_Maximum_XOR_After_Operations.runQuestion()
//    Question_2320_Count_Number_of_Ways_to_Place_Houses.runQuestion()
//    Question_2335_Minimum_Amount_of_Time_to_Fill_Cups.runQuestion()
//    Question_2337_Move_Pieces_to_Obtain_a_String.runQuestion()
//    Question_2343_Query_Kth_Smallest_Trimmed_Number.runQuestion()
//    Question_2344_Minimum_Deletions_to_Make_Array_Divisible.runQuestion()
//    Question_2357_Make_Array_Zero_by_Subtracting_Equal_Amounts.runQuestion()
//    Question_2364_Count_Number_of_Bad_Pairs.runQuestion()
//    Question_2365_Task_Scheduler_II.runQuestion()
//    Question_2375_Construct_Smallest_Number_From_DI_String.runQuestion()
//    Question_2381_Shifting_Letters_II.runQuestion()
//    Question_2384_Largest_Palindromic_Number.runQuestion()
//    Question_2385_Amount_of_Time_for_Binary_Tree_to_Be_Infected.runQuestion()
//    Question_2395_Find_Subarrays_With_Equal_Sum.runQuestion()
//    Question_2406_Divide_Intervals_Into_Minimum_Number_of_Groups.runQuestion()
//    Question_2420_Find_All_Good_Indices.runQuestion()
//    Question_2423_Remove_Letter_To_Equalize_Frequency.runQuestion()
//    Question_2425_Bitwise_XOR_of_All_Pairings.runQuestion()
//    Question_2438_Range_Product_Queries_of_Powers.runQuestion()
//    Question_2447_Number_of_Subarrays_With_GCD_Equal_to_K.runQuestion()
//    Question_2449_Minimum_Number_of_Operations_to_Make_Arrays_Similar.runQuestion()
//    Question_2457_Minimum_Addition_to_Make_Integer_Beautiful.runQuestion()
//    Question_2460_Apply_Operations_to_an_Array.runQuestion()
//    Question_2466_Count_Ways_To_Build_Good_Strings.runQuestion()
//    Question_2471_Minimum_Number_of_Operations_to_Sort_a_Binary_Tree_by_Level.runQuestion()
//    Question_2488_Count_Subarrays_With_Median_K.runQuestion()
//    Question_2492_Minimum_Score_of_a_Path_Between_Two_Cities.runQuestion()
//    Question_2497_Maximum_Star_Sum_of_a_Graph.runQuestion()
//    Question_2500_Delete_Greatest_Value_in_Each_Row.runQuestion()
//    Question_2512_Reward_Top_K_Students.runQuestion()
//    Question_2517_Maximum_Tastiness_of_Candy_Basket.runQuestion()
//    Question_2522_Partition_String_Into_Sustrings_With_Values_at_Most_K.runQuestion()
//    Question_2523_Closest_Prime_Numbers_in_Range.runQuestion()
//    Question_2525_Categorize_Box_According_to_Criteria.runQuestion()
//    Question_2541_Minimum_Operations_to_Make_Array_Equal_II.runQuestion()
//    Question_2546_Apply_Bitwise_Operations_to_Make_String_Equal.runQuestion()
//    Question_2550_Count_Collisions_of_Monkeys_on_a_Polygon.runQuestion()
//    Question_2555_Maximize_Win_From_Two_Segments.runQuestion()
//    Question_2567_Minimum_Score_by_Changing_Two_Elements.runQuestion()
//    Question_2571_Minimum_Operations_to_Reduce_an_Integer_to_0.runQuestion()
//    Question_2580_Count_Ways_to_Group_Overlapping_Ranges.runQuestion()
//    Question_2588_Count_the_Number_of_Beautiful_Subarrays.runQuestion()
//    Question_2593_Find_Score_of_an_Array_After_Marking_All_Elements.runQuestion()
//    Question_2607_Make_K_Subarray_Sums_Equal.runQuestion()
//    Question_2611_Mice_and_Cheese.runQuestion()
//    Question_2639_Find_the_Width_of_Columns_of_a_Grid.runQuestion()
//    Question_2641_Cousins_in_Binary_Tree_II.runQuestion()
//    Question_2643_Row_With_Maximum_Ones.runQuestion()
//    Question_2672_Number_of_Adjacent_Elements_With_the_Same_Color.runQuestion()
//    Question_2679_Sum_in_a_Matrix.runQuestion()
//    Question_2684_Maximum_Number_of_Moves_in_a_Grid.runQuestion()
//    Question_2685_Count_the_Number_of_Complete_Components.runQuestion()
//    Question_2698_Find_the_Punishment_Number_of_an_Integer.runQuestion()
//    Question_2733_Neither_Minimum_nor_Maximum.runQuestion()
//    Question_2745_Construct_the_Longest_New_String.runQuestion()
//    Question_2766_Relocate_Marbles.runQuestion()
//    Question_2779_Maximum_Beauty_of_an_Array_After_Applying_Operation.runQuestion()
//    Question_2860_Happy_Students.runQuestion()
//    Question_2915_Length_of_the_Longest_Subsequence_That_Sums_to_Target.runQuestion()
//    Question_2929_Distribute_Candies_Among_Children_II.runQuestion()
//    Question_2943_Maximize_Area_of_Square_Hole_in_Grid.runQuestion()
//    Question_2944_Minimum_Number_of_Coins_for_Fruits.runQuestion()
//    Question_2962_Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times.runQuestion()
//    Question_3015_Count_the_Number_of_Houses_at_a_Certain_Distance_I.runQuestion()
//    Question_3025_Find_the_Number_of_Ways_to_Place_People_I.runQuestion()
//    Question_3029_Minimum_Time_to_Revert_Word_to_Initial_State_I.runQuestion()
//    Question_3040_Maximum_Number_of_Operations_With_the_Same_Score_II.runQuestion()
//    Question_3043_Find_the_Length_of_the_Longest_Common_Prefix.runQuestion()
//    Question_3047_Find_the_Largest_Area_of_Square_Inside_Two_Rectangles.runQuestion()
//    Question_3071_Minimum_Operations_to_Write_the_Letter_Y_on_a_Grid.runQuestion()
//    Question_3076_Shortest_Uncommon_Substring_in_an_Array.runQuestion()
//    Question_3080_Mark_Elements_on_Array_by_Performing_Queries.runQuestion()
//    Question_3107_Minimum_Operations_to_Make_Median_of_Array_Equal_to_K.runQuestion()
//    Question_3132_Find_the_Integer_Added_to_Array_II.runQuestion()
//    Question_3143_Maximum_Points_Inside_the_Square.runQuestion()
//    Question_3147_Taking_Maximum_Energy_From_the_Mystic_Dungeon.runQuestion()
//    Question_3153_Sum_of_Digit_Differences_of_All_Pairs.runQuestion()
//    Question_3168_Minimum_Number_of_Chairs_in_a_Waiting_Room.runQuestion()
//    Question_3169_Count_Days_Without_Meetings.runQuestion()
//    Question_3170_Lexicographically_Minimum_String_After_Removing_Stars.runQuestion()
//    Question_3171_Find_Subarray_With_Bitwise_OR_Closest_to_K.runQuestion()
//    Question_3178_Find_the_Child_Who_Has_the_Ball_After_K_Seconds.runQuestion()
//    Question_3179_Find_the_N_th_Value_After_K_Seconds.runQuestion()
//    Question_3180_Maximum_Total_Reward_Using_Operations_I.runQuestion()
//    Question_3181_Maximum_Total_Reward_Using_Operations_II.runQuestion()
//    Question_3184_Count_Pairs_That_Form_a_Complete_Day_I.runQuestion()
//    Question_3185_Count_Pairs_That_Form_a_Complete_Day_II.runQuestion()
//    Question_3186_Maximum_Total_Damage_With_Spell_Casting.runQuestion()
//    Question_3194_Minimum_Average_of_Smallest_and_Largest_Elements.runQuestion()
//    Question_3195_Find_the_Minimum_Area_to_Cover_All_Ones_I.runQuestion()
//    Question_3196_Maximize_Total_Cost_of_Alternating_Subarrays.runQuestion()
//    Question_3200_Maximum_Height_of_a_Triangle.runQuestion()
//    Question_3201_Find_the_Maximum_Length_of_Valid_Subsequence_I.runQuestion()
//    Question_3202_Find_the_Maximum_Length_of_Valid_Subsequence_II.runQuestion()
//    Question_3210_Find_the_Encrypted_String.runQuestion()
//    Question_3211_Generate_Binary_Strings_Without_Adjacent_Zeros.runQuestion()
//    Question_3212_Count_Submatrices_With_Equal_Frequency_of_X_and_Y.runQuestion()
//    Question_3218_Minimum_Cost_for_Cutting_Cake_I.runQuestion()
//    Question_3226_Number_of_Bit_Changes_to_Make_Two_Integers_Equal.runQuestion()
//    Question_3227_Vowels_Game_in_a_String.runQuestion()
//    Question_3228_Maximum_Number_of_Operations_to_Move_Ones_to_the_End.runQuestion()
//    Question_3232_Find_if_Digit_Game_Can_Be_Won.runQuestion()
//    Question_3233_Find_the_Count_of_Numbers_Which_Are_Not_Special.runQuestion()
//    Question_3234_Count_the_Number_of_Substrings_With_Dominant_Ones.runQuestion()
//    Question_3243_Shortest_Distance_After_Road_Addition_Queries_I.runQuestion()
//    Question_3248_Snake_in_Matrix.runQuestion()
//    Question_3249_Count_the_Number_of_Good_Nodes.runQuestion()
//    Question_3290_Maximum_Multiplication_Score.runQuestion()
//    Question_3296_Minimum_Number_of_Seconds_to_Make_Mountain_Height_Zero.runQuestion()
//    Question_3310_Remove_Methods_From_Project.runQuestion()
}